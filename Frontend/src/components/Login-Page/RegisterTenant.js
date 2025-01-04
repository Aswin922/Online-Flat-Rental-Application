import React, { useState , useEffect } from 'react';
import axios from 'axios';
import styles from '../Login-Page/login.module.css';
import { Link } from 'react-router-dom';

function RegisterTenant(){
    let initialuser={userId:0,userName:'',password:'',userType:'tenant'};
    let [formValues,setUser]=useState(initialuser);
    const [formErrors,setFormErrors] = useState({});
    const [formErrors1,setFormErrors1] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);
    // const [formErrors, setFormErrors] = useState({});
    // const [isSubmit, setIsSubmit] = useState(false);
    useEffect(()=>{
        console.log(formErrors);
        if(Object.keys(formErrors).length===0 && isSubmit){
            console.log(formValues);
        }

    },[formErrors, formValues, isSubmit])
    const validate = (values) =>{
        const errors ={}
        if(!values.userName){
            errors.userName = "Username is Required!"
        }
        if(!values.password){
            errors.password = "Password is Required!"
        }
        return errors;
    };

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

      useEffect(()=>{
        console.log(formErrors1);
        if(Object.keys(formErrors1).length===0 && isSubmit){
            console.log(tenant);
        }
    },[formErrors1])

    const validate1 = (values) =>{
        const errors ={}
        
        if(!values.taddress.houseNo){
            errors.houseNo = "House no. is Required!"
        }
        if(!values.taddress.street){
            errors.street = "Street is Required!"
        }
        if(!values.taddress.city){
            errors.city = "City is Required!"
        }
        if(!values.taddress.state){
            errors.state = "State is Required!"
        }
        if(!values.taddress.pin){
            errors.pin = "Pincode is Required!"
        }
        if(!values.taddress.country){
            errors.country = "Country is Required!"
        }
        if(!values.age){
            errors.age = "Age is Required!"
        }
        return errors;
    };

      function handleTenant(e)
        {
            e.preventDefault();
            setFormErrors(validate(formValues));
            setFormErrors1(validate1(tenant));
            console.log(tenant);
            const URL1='http://localhost:8080/users/addUser';
            axios.post(URL1,formValues).then((response) => 
            {                    
                setUser(initialuser);
            }).catch(error => console.log(error.message))    

            const URL2='http://localhost:8080/tenant/addtenant';
            axios.post(URL2,tenant).then((response) => 
            {
                 // setMsg(response.data);
                setTenant(initialtenant);
                window.alert("Tenant Registered...");
            }).catch(error => console.log(error.message))
            
        }

    return (
        <React.Fragment>
            <form className="c2" method="POST">
            <h1 className="form-text ">Register Tenant</h1>
             <br/><br/><br/><br/>
             <label>Username</label>
            <input name="username" type="text" placeholder="Username*" className="username"
             value={formValues.userName} onChange={e=>setUser({...formValues,userName:e.target.value})}
            />
            <p>{formErrors.userName}</p>
            <br/>
            <label>Password</label>
            <input name="password" type="password" placeholder="Password*" className="username"
            value={formValues.password} onChange={e=>setUser({...formValues,password:e.target.value})}
            />
            <p>{formErrors.password}</p>
            <br/>
            <div className='form-group'>
                <label>House Number<span style={{color: "red"}}>*</span></label>
                <input name="flatid" placeholder="Flat Number" type='number' className="username"
                     value={tenant.taddress.houseNo}
                    //  onInput={formValidate}
                     onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,houseNo:e.target.value}})}/>
                     <p>{formErrors1.houseNo}</p>
            </div>
            <div className='form-group'>
                <label>Street<span style={{color: "red"}}>*</span></label>
                <input name="street" placeholder="Street name" className="username" 
                    value={tenant.taddress.street} 
                    // onInput={formValidate}
                    onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,street:e.target.value}})}/>
                    <p>{formErrors1.street}</p>
            </div>
            <div className='form-group'>
                <label>Pin code<span style={{color: "red"}}>*</span></label>
                <input name="pincode" placeholder="If other than India--> 999999" type='number' 
                className="username"
                value={tenant.taddress.pin} 
                // onInput={formValidate}
                onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,pin:e.target.value}})}/>
                <p>{formErrors1.pin}</p>
            </div>
            <div className='form-group'>
                <label>City<span style={{color: "red"}}>*</span></label>
                <input name="city" placeholder="City name" className="username" 
                value={tenant.taddress.city} 
                // onInput={formValidate}
                onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,city:e.target.value}})}/>
                <p>{formErrors1.city}</p>
            </div>
            <div className='form-group'>
                <label>State<span style={{color: "red"}}>*</span></label>
                <input name="state" placeholder="State name" 
                className="username" value={tenant.taddress.state} 
                // onInput={formValidate}
                onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,state:e.target.value}})}/>
                <p>{formErrors1.state}</p>
            </div>
            <div className='form-group'>
                <label>Country<span style={{color: "red"}}>*</span></label>
                <input name="country" placeholder="Country name"  className="username" 
                // onInput={formValidate}
                value={tenant.taddress.country} 
                onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,country:e.target.value}})}/>
                <p>{formErrors1.country}</p>
            </div>
        <br/><br/>
        <input name="tenantage" type="number" placeholder="Tenant Age" className="username"
         value={tenant.age} onChange={e=>setTenant({...tenant,age:e.target.value})}/>
        <p>{formErrors1.age}</p>
            <br/>
            <button className="btn" type="submit" onClick={handleTenant} data-testid="button">Register Tenant</button>
            </form>
        </React.Fragment>
    )
}

export default RegisterTenant