import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function UpdateFlat() {
    
    let initialFlat={
        flatId: '',
        flatAddress:{
            houseNo:'',
            street:'',
            city:'',
            state:'',
            pin:'',
            country:''
            },
        availability:'',
        cost:'',
        };

    const [Flat,setFlat]=useState(initialFlat);
    const [formErrors, setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);

    function handleBtnClick(e)
  {
      e.preventDefault();
      setFormErrors(validate(Flat));
      setIsSubmit(true);
      const URL=`http://localhost:8080/flat/updateflat/${Flat.flatId}`;
      axios.put(URL,Flat).then((response) => 
      { setFlat(response.data);
        window.alert("Flat Updated...");
        setFlat(initialFlat);}
      )
      .catch(error => console.log(error.message))

  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(Flat);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values.flatId) {
        errors.flatId = "Flat Id is required!";
      }
    if (!values.flatAddress.houseNo) {
      errors.houseNo = "House No is required!";
    }
    if (!values.flatAddress.street) {
        errors.street = "Street is required!";
      }
    if (!values.flatAddress.city) {
        errors.city = "City is required!";
      }
    if (!values.flatAddress.state) {
        errors.state = "State is required!";
      }
    if (!values.flatAddress.pin) {
        errors.pin = "PIN is required!";
      }
    if (!values.flatAddress.country) {
        errors.country = "Country is required!";
      }
    if (!values.availability) {
      errors.availability = "Availability is required!";
    } 
    if (!values.cost) {
      errors.cost = "Cost is required!";
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
      <form className="c2">
      <h1 className="form-text ">Update Flat</h1>
            <br/>  <br/>  
            <label>Flat Id</label>
       <input name="flatid" type="number" placeholder="Flat ID" className="username" 
       value={Flat.flatId} onChange={e=>setFlat({...Flat,flatId:e.target.value})}
       />
       <p>{formErrors.flatId}</p>
       
            <label>House No</label>
       <input name="flatid" type="number" placeholder="House No" className="username" 
       value={Flat.flatAddress.houseNo} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,houseNo:e.target.value}})}
       />
       <p>{formErrors.houseNo}</p>
       
            <label>Street</label>
       <input name="flatid" type="text" placeholder="Street" className="username" 
       value={Flat.flatAddress.street} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,street:e.target.value}})}
       />
       <p>{formErrors.street}</p>
       
            <label>City</label>
       <input name="flatid" type="text" placeholder="City" className="username" 
       value={Flat.flatAddress.city} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,city:e.target.value}})}
       />
       <p>{formErrors.city}</p>
       
            <label>State</label>
       <input name="flatid" type="text" placeholder="State" className="username" 
       value={Flat.flatAddress.state} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,state:e.target.value}})}
       />
       <p>{formErrors.state}</p>
       
            <label>Pin</label>
       <input name="flatid" type="number" placeholder="Pin" className="username" 
       value={Flat.flatAddress.pin} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,pin:e.target.value}})}
       />
       <p>{formErrors.pin}</p>
       
            <label>Country</label>
       <input name="flatid" type="text" placeholder="Country" className="username" 
       value={Flat.flatAddress.country} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,country:e.target.value}})}
       />
       <p>{formErrors.country}</p>
        
            <label>Cost</label>
       <input name="flatid" type="number" placeholder="Cost" className="username" 
       value={Flat.cost} onChange={e=>setFlat({...Flat,cost:e.target.value})}
       />
       <p>{formErrors.cost}</p>


       <label>Availability</label>
        <select name="availability" className="username"
        value={Flat.availability} onChange={e=>setFlat({...Flat,availability:e.target.value})}
        >
          <option value="">Availability*</option>
          <option value="available">Available</option>
          <option value="unavailable">Unavailable</option>
         </select>
         <p>{formErrors.availability}</p>
         <br/>  <br/>
         <button className="btn" data-testid="button" onClick={handleBtnClick}>Update Flat</button>
      
      </form>
      </React.Fragment>
    );
}

export default UpdateFlat;
