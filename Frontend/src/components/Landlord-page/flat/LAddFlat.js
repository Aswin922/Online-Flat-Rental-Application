import React ,{useState,useEffect} from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom';

function LAddFlat() {

    let initialFlat={
        flatAddress:{
            houseNo:'',
            street:'',
            city:'',
            state:'',
            pin:0,
            country:''
            },
        availability:'',
        cost:'',
        flatId:0,
        landlordId:{landlordId:0}

        }
    let [Flat,setFlat]=useState(initialFlat)
    const [formErrors, setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);
    let [msg,setMsg]=useState('')
    let [id,setId]=useState(0)

    const validate = (values) => {
        const errors = {};
        if (!values.flatId) {
            errors.flatId = "Flat Id is required!";
          }
        if (!values.flatAddress.houseNo) {
          errors.houseNo = "House No is required!";
        }
        if (!values.availability) {
          errors.availability = "Availability is required!";
        } 
        if (!values.cost || values.cost<1000) {
          errors.cost = "Cost is required ";
        } 
        return errors;
      };

    function handleBtnClick(e)
  {
      e.preventDefault();
      setFormErrors(validate(Flat));
      setIsSubmit(true);
      const URL='http://localhost:8080/flat/addflat';
      axios.post(URL,Flat).then((response) => 
      {
          window.alert("Flat Added...");
          setFlat(initialFlat);
      }).catch(error => console.log(error.message))
      
  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(Flat);
    }
  }, [formErrors]);

    return (
        <React.Fragment>
        <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <Link className="navbar-brand navbar-brand-margin">Admin Panel</Link>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
      {Object.keys(formErrors).length === 0 && isSubmit ? (
        <div className="ui message success">Flat Added.</div>
      ) : (<></>
        
      )}
      
      <form className="c2" method="POST">
    <h1 className="form-text ">Add Flat</h1>
    <br/>

       
            <label>House No</label>
       <input name="flatid" type="number" placeholder="House No" className="username" 
       value={Flat.flatAddress.houseNo} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,houseNo:e.target.value}})}
       />
       <p>{formErrors.houseNo}</p>


            <label>Cost</label>
       <input name="flatid" type="number" placeholder="Cost" className="username" 
       value={Flat.cost} onChange={e=>setFlat({...Flat,cost:e.target.value})}
       />
       <p>{formErrors.cost}</p>

       <label>Availability</label>
        <select name="availability" className="username"
        value={Flat.availability} onChange={e=>setFlat({...Flat,availability:e.target.value})}
        >
          <option value="">Availability</option>
          <option value="available">Available</option>
          <option value="unavailable">Unavailable</option>
         </select>
         <p>{formErrors.availability}</p>
         <br/>

         <button className="btn" data-testid="button" onClick={handleBtnClick}>Add Flat</button>
      
      </form>

        </React.Fragment>
    )
}

export default LAddFlat;
