import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function RemoveBooking() {

   const [bookingid,setBookingid] = useState(0);
   const [formErrors, setFormErrors] = useState({});
   const [isSubmit, setIsSubmit] = useState(false);


  const handleBtnClick = (e)=>{
      // console.log(e.target.response)
      e.preventDefault();
      setFormErrors(validate(bookingid));
      setIsSubmit(true);
      axios.delete(`http://localhost:8080/flatbooking/deleteflatbooking/${bookingid}`)
      .then(() => {
        window.alert("Flat Booking Removed");
        setBookingid(0);
      }).catch(error => console.log(error.message));
  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(bookingid);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values) {
        errors.bookingid = "Booking id is required!";
    }
    return errors;
  };

   return (
      <React.Fragment>
        <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <Link className="navbar-brand navbar-brand-margin">Admin Panel</Link>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
        <form className="c2 view-form" data-testid="Remove-form-2">
            <h1 className="form-text " data-testid="Remove-header-2" >Delete FlatBooking By ID</h1>
           <br/>
           <label>FlatBooking Id</label>
            <input name="flatbookingid" type="number" placeholder="FlatBooking ID*" className="username" 
             value = {bookingid}
             onChange={e=>setBookingid(e.target.value)}
            />
            <br/>
            <p>{formErrors.bookingid}</p>
            <button className="btn" data-testid="buttonBookingRemove" onClick={handleBtnClick}>Delete Flat</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveBooking; 
