import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function RemoveFlat() {

   const [flatid,setFlatid] = useState(0);
   const [formErrors, setFormErrors] = useState({});
   const [isSubmit, setIsSubmit] = useState(false);


  const handleBtnClick = (e)=>{
      // console.log(e.target.response)
      e.preventDefault();
      setFormErrors(validate(flatid));
      setIsSubmit(true);
      axios.delete(`http://localhost:8080/flat/deleteflat/${flatid}`)
      .then(() => {
        window.alert("Flat Removed");
        setFlatid(0);
      }).catch(error => console.log(error.message));
  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(flatid);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values) {
        errors.flatid = "Flat Id is required!";
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
        <form className="c2 view-form">
            <h1 className="form-text ">Delete Flat By ID</h1>
           <br/>
           <label>Flat Id</label>
            <input name="flatid" type="number" placeholder="Flat ID*" className="username" 
             value = {flatid}
             onChange={e=>setFlatid(e.target.value)}
            />
            <br/>
            <p>{formErrors.flatid}</p>
            <button className="btn" data-testid="button" onClick={handleBtnClick}>Delete Flat</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveFlat; 
