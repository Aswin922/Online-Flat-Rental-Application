import React, { useEffect, useState } from 'react';
import axios from 'axios';

function UpdateLandlord() {

  let initiallandlord={flatList:[], landlordAge: '', landlordId: '', landlordName: ''};
    const [landlord,setLandlord] = useState(initiallandlord);
    const [formErrors, setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);
 
   
   function handleBtnClick(e)
   {
       e.preventDefault();
       setFormErrors(validate(landlord));
       setIsSubmit(true);
       const URL=`http://localhost:8080/landlord/updatelandlord/${landlord.landlordId}`;
       axios.put(URL,landlord).then((response) => 
       {setLandlord(response.data)
        window.alert("Landlord Updated");
        setLandlord(initiallandlord)
      })
       .catch(error => console.log(error.message))
   }
 
   useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(landlord);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values.landlordId) {
      errors.landlordId = "Landlord id is required!";
    }
    if (!values.landlordName) {
      errors.landlordName = "Landlord name is required!";
    }
    if (!values.landlordAge) {
      errors.landlordAge = "Landlord age is required!";
    } 

    return errors;
  };

   return (
      <React.Fragment>
        <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn"><a href="/admin">Admin Panel</a></button>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
        
       <form id = "" className="c2 booking-form updatelandlordform">
        <h1 className="form-text">Update Landlord</h1>
        <input name="landlordid" type="text" placeholder="Landlord ID" className="col-md-4 address-tags"
        value={landlord.landlordId} onChange={e=>setLandlord({...landlord,landlordId:e.target.value})}/><br/>
        <p>{formErrors.landlordId}</p>
        <input name="landlordname" type="text" placeholder="Landlord Name" className="col-md-4 address-tags"
        value={landlord.landlordName} onChange={e=>setLandlord({...landlord,landlordName:e.target.value})}/><br/>
        <p>{formErrors.landlordName}</p>
        <input name="landlordage" type="number" placeholder="Landlord Age" min="18" className="col-md-3 address-tags"
        value={landlord.landlordAge} onChange={e=>setLandlord({...landlord,landlordAge:e.target.value})}/><br/>
        <p>{formErrors.landlordAge}</p>
        
        <button className="btn" data-testid="button" onClick={handleBtnClick}>Update Landlord</button>
        
     </form>
<br/><br/>

    </React.Fragment>
    );
}

export default UpdateLandlord;