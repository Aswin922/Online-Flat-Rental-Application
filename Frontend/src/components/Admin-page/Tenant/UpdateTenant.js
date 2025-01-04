import React, { useEffect, useState } from 'react';
import axios from 'axios';

function UpdateTenant() {
   let initialtenant={taddress:{
      houseNo:0,
      street:'',
      city:'',
      state:'',
      pin:0,
      country:''
      },age:'',
  tenantId:0};
    let [tenant,setTenant]=useState(initialtenant);

    function handleBtnClick(e)
    {
        e.preventDefault();
        console.log(tenant);
        const URL=`http://localhost:8080/tenant/updatetenant/${tenant.tenantId}`;
    axios.put(URL,tenant).then((response) => 
    {
        // setMsg(response.data);
        window.alert("Tenant Updated...");
          setTenant(initialtenant);
    }).catch(error => console.log(error.message))
    }

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
            <h1 className="form-text">Update Tenant</h1>
         <br/><br/><br/>
         <label>Tenant Id<span style={{color: "red"}}>*</span></label>
            <input name="tenantid" type="text" placeholder="Tenant ID" className="col-md-4 address-tags"
             value={tenant.tenantId} onChange={e=>setTenant({...tenant,tenantId:e.target.value})}
            />
            <br/><br/>
                <div className='form-group'>
                    <label>House Number<span style={{color: "red"}}>*</span></label>
                    <input name="flatid" placeholder="Flat Number" type='number' className='form-control'
                         value={tenant.taddress.houseNo}
                        //  onInput={formValidate}
                         onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,houseNo:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Street<span style={{color: "red"}}>*</span></label>
                    <input name="street" placeholder="Street name" className='form-control' 
                        value={tenant.taddress.street} 
                        // onInput={formValidate}
                        onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,street:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Pin code<span style={{color: "red"}}>*</span></label>
                    <input name="pincode" placeholder="If other than India--> 999999" type='number' 
                    className='form-control' 
                    value={tenant.taddress.pin} 
                    // onInput={formValidate}
                    onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,pin:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>City<span style={{color: "red"}}>*</span></label>
                    <input name="city" placeholder="City name" className='form-control' 
                    value={tenant.taddress.city} 
                    // onInput={formValidate}
                    onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,city:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>State<span style={{color: "red"}}>*</span></label>
                    <input name="state" placeholder="State name" 
                    className='form-control' value={tenant.taddress.state} 
                    // onInput={formValidate}
                    onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,state:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Country<span style={{color: "red"}}>*</span></label>
                    <input name="country" placeholder="Country name"  className='form-control' 
                    // onInput={formValidate}
                    value={tenant.taddress.country} 
                    onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,country:e.target.value}})}/>
                </div>
<br/><br/>
            <input name="tenantage" type="number" placeholder="Tenant Age" className="col-md-4 address-tags"
             value={tenant.age} onChange={e=>setTenant({...tenant,age:e.target.value})}
            />
        <br/><br/>
            <button className="btn" data-testid="button" onClick={handleBtnClick}>Update Tenant</button>
        </form>

    </React.Fragment>
    );
}

export default UpdateTenant;