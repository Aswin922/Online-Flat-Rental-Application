import React, { useState, useEffect } from "react";
import axios from "axios";
{/*You will provide only your tenant id */}
function TInfo(props) {
    let initialTenant = {
        tenantId: 0,
        taddress:{
            houseNo:0,
            street:'',
            city:'',
            state:'',
            pin:0,
            country:''
            },
        age: 0
      };
      
    let [Tenant, setTenant] = useState(initialTenant);
    let [id, setId] = useState(null);
    let [btnId,setBtnId]=useState(0);
    
    function formValidate() {
        const form = document.querySelector('form');

        var tid=form.elements.tenantid.value;
    
        var error=document.getElementById("error")
    
        var gbtn=document.getElementById("getbtn")
    
        if(tid<=0){
          error.innerHTML="Tenant ID: Provide a positive integer"
        }
        else if(tid%1!==0){
            error.innerHTML="Tenant ID: Provide an integer value"
        }
        else{
          error.innerHTML=""
          gbtn.style.pointerEvents="auto"
      }
    
      }
      useEffect(() => {
        const URL = `http://localhost:8080/tenant/viewtenant/${id}`;
        axios
          .get(URL)
          .then((response) => {
            setTenant(response.data);
            setBtnId(id);
          })
          .catch((error) => console.log(error.response));
      }, [btnId]);
      const handleBtnClick=(event)=>
        {
            event.preventDefault();
            setBtnId(id)
        }

    return(((btnId!==0)&&Tenant.age!==0)?<>
    <div style={{height:"460px",backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
    <h2 className="text-primary container">Profile</h2>
      <hr />
      <div className="form-group container">
        <form className="col-3" onSubmit={handleBtnClick}>
        <h6 className="text text-primary" style={{margin:"10px 0px"}}>Confirm your Identification</h6>
                <input
                name="tenantid"
                type="number"
                min="1" max='10000'
                className="form-control"
                value={id}
                onInput={formValidate}
                onChange={(e) =>setId(e.target.value)}
                placeholder="Tenant ID"
                />
                <button id="getbtn" style={{margin:"10px 0px"}} className='btn btn-success'>Get Details</button>
                <h6 id="error" className="text text-danger"></h6>
        </form>
        </div>
        <table className="table table-bordered table-hover container table-striped">
            <thead style={{color:"white",backgroundColor: "#b23850"}}>
                    <tr><th colSpan={2}>Tenant Details</th></tr>
            </thead>
            <tbody style={{backgroundColor: "#c4dbf6 "}}>
                <tr>
                    <td><b>Tenant ID:</b></td>
                    <td>{Tenant.tenantId}</td>
                </tr>
                <tr>
                    <td><b>Tenant Address House No.:</b></td>
                    {/* <td>{Tenant.tAddress.houseNo}</td> */}
                    <td>{Tenant.taddress&&Tenant.taddress.houseNo}</td>
                </tr>
                <tr>
                    <td><b>Age:</b></td>
                    {/* <td>{Tenant.tenantAge}</td> */}
                    <td>{Tenant&&Tenant.age}</td>
                </tr>
                
            </tbody>
        </table>
        
        </div>
        </>:<>
        <div style={{height:"460px",backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
            <h2 className="text-primary container">Profile</h2>
            <hr />
            <div className="form-group container">
                <form className="col-3" onSubmit={handleBtnClick}>
                <h6 className="text text-primary" style={{margin:"10px 0px"}}>Confirm your Identification</h6>
                        <input
                        name="tenantid"
                        type="number"
                        min="1" max='10000'
                        className="form-control"
                        value={id}
                        onInput={formValidate}
                        onChange={(e) =>setId(e.target.value)}
                        placeholder="Tenant ID"/>
                        <button id="getbtn" style={{margin:"10px 0px"}} className='btn btn-success'>Get Details</button>
                        <h6 id="error" className="text text-danger"></h6>
                </form>
            </div>
            </div>
        </>
        
        );
}
export default TInfo;
