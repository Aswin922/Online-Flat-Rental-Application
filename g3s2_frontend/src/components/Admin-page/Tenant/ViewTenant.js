import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewTenant() {
  const [tenantid,setTenantid] = useState(0);
  const [tenantDetail,setTenantDetail] = useState([]);
  // const [btn,setButton] = useState(0);
  // const [deletebtn,setdeleteButton] = useState(0);

//   useEffect(() => {
//     // DELETE request using axios inside useEffect React hook
    
// }, [btn]);

    //  useEffect(()=>{
    //      const URL=`http://localhost:8080/tenant/deletetenant/${tenantid}`
    //      axios
    //       .delete(URL)
    //       .then((response)=>
    //          {
    //              setTenantDetail([]);
    //              setTenant(0);
    //              btn(0);
    //          })
    //          .catch(error=>console.log(error.response));
    //  },[deletebtn]);




const handleBtnClick = (e)=>{
 e.preventDefault();
//  setButton(tenantid)
 const URL=`http://localhost:8080/tenant/viewtenant/${tenantid}`
 axios
   .get(URL)
   .then((response) => {
   
   console.log(response.data);
   setTenantDetail(response.data)})
   .catch((error)=>console.log(error.response));
}


// const handleDeleteBtnClick =(e)=>{
//    e.preventDefault();
//    setdeleteButton(1)
// }


   return (
      <React.Fragment>
        <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn"><a href="/admin">Admin Panel</a></button>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
            <form className="view-form">
    <h1 className="form-text ">View Tenant By ID</h1>
    <br/>
    <input name="username" type="number" placeholder="Tenant ID*" className="username"
     value = {tenantid}
     onChange={e=>setTenantid(e.target.value)}
    />
    <br/>
    <button className="btn" data-testid="button" onClick={handleBtnClick}>View Tenant</button>
   </form>
   

 <table className="table table-data table-striped table-bordered view-table">
    <thead>
        <tr className="table-warning">
          <th>ID</th>
          <th>HOUSE NO</th>
            <th>STREET</th>
            <th>CITY</th>
            <th>PIN</th>
            <th>STATE</th>
            <th>COUNTRY</th>
          <th>Age</th>
        </tr>
      </thead>
      <tbody className="table-success ">
        <tr>
          <td>{tenantDetail&&tenantDetail.tenantId}</td>
          <td>{tenantDetail.taddress&&tenantDetail.taddress.houseNo}</td>
          <td>{tenantDetail.taddress&&tenantDetail.taddress.street}</td>
          <td>{tenantDetail.taddress&&tenantDetail.taddress.city}</td>
          <td>{tenantDetail.taddress&&tenantDetail.taddress.pin}</td>
          <td>{tenantDetail.taddress&&tenantDetail.taddress.state}</td>
          <td>{tenantDetail.taddress&&tenantDetail.taddress.country}</td>
          <td>{tenantDetail&&tenantDetail.age}</td>
          {/* <td>
            <button className="btn btn-info logout-btn" type="submit">View Flats</button>
          </td> */}
          {/* <td>
            <button className="btn btn-warning logout-btn" type="submit">Update</button>
            <button className="btn btn-danger logout-btn" type="submit"
            onClick={handleDeleteBtnClick}
            >Delete</button>
          </td> */}
        </tr>
      
       
      </tbody>

  </table>     

      </React.Fragment>
    );
}

export default ViewTenant;