import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewAllBooking() {

    let initialCustomers=[];
    let [bookings,setBookings]=useState(initialCustomers);

    useEffect(() => {
        const URL = 'http://localhost:8080/flatbooking/viewAllFlatBooking';
        axios.get(URL).then((response) => {
            setBookings(response.data);
        })
        .catch((error) => console.log(error));
    },[]);

    function goToAddCustomer(){
        //props.history.push('/addCustomer');
    }


  return (
      <React.Fragment>
        <table className="table table-data table-striped table-bordered" data-testid="ViewAll-form-2">
                <thead>
                    <tr className="table-warning">
                    <th>Booking No.</th>
                    <th> Flat ID</th>
                    <th>Tenant ID</th>
                    <th>Booking From</th>
                    <th>Booking From</th>
                    {/* <th>Actions</th> */}
                    </tr>
                </thead>
                <tbody className="table-success">
                {
                bookings.map (
                    booking =>

                    <tr>
                    <td>{booking.bookingNo}</td>
                    <td>{booking.flat.flatId}</td>
                    <td>{booking.tenantId.tenantId}</td>
                    <td>{booking.bookingFromDate}</td>
                    <td>{booking.bookingToDate}</td>
                    </tr>
                
                )}
                </tbody>

            </table>
    </React.Fragment>
    );
}

export default ViewAllBooking;