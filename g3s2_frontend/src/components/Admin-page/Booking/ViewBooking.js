import React, { useEffect, useState } from 'react';
import axios from 'axios';


function ViewBooking() {

  const [id,setId] = useState(0);
  let initialFlatBooking={}
  let [booking,setBooking]=useState(initialFlatBooking);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);


  const handleBtnClick = (e)=>{
    e.preventDefault();
    setFormErrors(validate(id));
    setIsSubmit(true);
    const URL = `http://localhost:8080/flatbooking/viewflatbooking/${id}`;
      axios.get(URL).then((response) => {
          setBooking(response.data);
      })
      .catch((error) => console.log(error));
  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(id);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values) {
        errors.id = "Booking id is required!";
    }
    return errors;
  };


return (
    <React.Fragment>
      <form className="view-form" data-testid="View-form-2"> 
                <h1 className="form-text ">View Booking By ID</h1>
                <br/>
                <label>Booking Id</label>
                <input name="userId" type="number" placeholder="Booking ID*" className="username"
                  value = {id}
                  onChange={e=>setId(e.target.value)}
                />
                <p>{formErrors.id}</p>
                <button className="btn" data-testid="buttonBookingViewId" onClick={handleBtnClick}>View Booking</button>
            </form>
      <table className="table table-data table-striped table-bordered view-table">
              <thead>
                  <tr className="table-warning">
                  <th>Booking No.</th>
                  <th> Flat ID</th>
                  <th>Tenant ID</th>
                  <th>Booking From</th>
                  <th>Booking From</th>
                  </tr>
              </thead>
              <tbody className="table-success">
                  <tr>
                  <td>{booking&&booking.bookingNo}</td>
                  <td>{booking&&booking.flat&&booking.flat.flatId}</td>
                  <td>{booking&&booking.tenantId&&booking.tenantId.tenantId}</td>
                  <td>{booking&&booking.bookingFromDate}</td>
                  <td>{booking&&booking.bookingToDate}</td>
                  </tr>

              </tbody>

          </table>
  </React.Fragment>
  );
}

export default ViewBooking;