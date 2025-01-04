import React, { useEffect, useState } from 'react';
import axios from 'axios';


function AddLandlord() {

  let initiallandlord={flatList:[], landlordAge: '', landlordId: 0, landlordName: ''};
  let [landlord,setLandlord]=useState(initiallandlord);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);

    function handleBtnClick(e)
  {
      e.preventDefault();
      setFormErrors(validate(landlord));
      setIsSubmit(true);
      const URL='http://localhost:8080/landlord/addlandlord';
    axios.post(URL,landlord).then((response) => 
    {
        window.alert("Landlord Added...");
        setLandlord(initiallandlord);
    }).catch(error => console.log(error.message))   
  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(landlord);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
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

        {Object.keys(formErrors).length === 0 && isSubmit ? (
        <div className="ui message success">Landlord Added.</div>
      ) : (<></>
        // <pre>{JSON.stringify(user, undefined, 2)}</pre>
      )}
        <form class="c2" method= "POST">
    <h1 class="form-text">Add Landlord</h1>
    <br/><br/>
    

    <input name="landlordname" type="text" placeholder="Landlord Name" class="col-md-4 address-tags"
    value={landlord.landlordName} onChange={e=>setLandlord({...landlord,landlordName:e.target.value})}/>
    <p>{formErrors.landlordName}</p>
    <br/>
    <input name="landlordeage" type="number" placeholder="Landlord Age" class="col-md-4 address-tags"
    value={landlord.landlordAge} onChange={e=>setLandlord({...landlord,landlordAge:e.target.value})}/>
    <p>{formErrors.landlordAge}</p>
    <br/>
    <br/><br/><br/><br/>
  
    <button  className="btn" type="submit" data-testid="button" onClick={handleBtnClick}>Add Landlord</button>
 </form>
    
     </React.Fragment>
    );
}

export default AddLandlord;