import React,{useState} from 'react';
import './admin.css';
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';



function AdminPage(props) {
    const [value,setValue]=useState('');
    const handleSelect=(e)=>{
      console.log(e);
      setValue(e)
    }

function togglebtn(){
      var dropdown = document.getElementsByClassName("dropdown-btn");

      var i;

      for (i = 0; i < dropdown.length; i++) {
        dropdown[i].addEventListener("click", function() {
          this.classList.toggle("active");
          var dropdownContent = this.nextElementSibling;
          if (dropdownContent.style.display === "block") {
            dropdownContent.style.display = "none";
          } else {
            dropdownContent.style.display = "block";
          }
        });
      }
    }

    



    return (
      
      <React.Fragment>
      <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <Link className="navbar-brand navbar-brand-margin">Admin Panel</Link>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>

      <div className="sidenav col-md-2">
        <button className="dropdown-btn" onClick={togglebtn}>Users
          <i className="fa fa-caret-down"></i>
        </button>
        <div className="dropdown-container">
          <Link to="/admin/user/adduser">Add User</Link>
          <Link to="/admin/user/updateuser">Update User</Link>
          <Link to="/admin/user/removeuser">Remove User</Link>
          <Link to="/admin/user/viewuser">View User By ID</Link>
          <Link to="/admin/user/viewalluser">View All User</Link>
        </div>
        
        <button  className="dropdown-btn" onClick={togglebtn}>Landlord 
          <i className="fa fa-caret-down"></i>
        </button>
        <div className="dropdown-container">
          <Link to="/admin/landlord/addlandlord">Add Landlord</Link>
          <Link to="/admin/landlord/updatelandlord">Update Landlord</Link>
          <Link to="/admin/landlord/removelandlord">Delete Landlord</Link>
          <Link to="/admin/landlord/viewlandlord">View Landlord By ID</Link>
          <Link to="/admin/landlord/viewalllandlord">View All Landlord</Link>
        </div>

        <button  className="dropdown-btn" onClick={togglebtn}>Tenant
          <i className="fa fa-caret-down"></i>
        </button>
        <div  className="dropdown-container">
          <Link to="/admin/tenant/addtenant">Add Tenant</Link>
          <Link to="/admin/tenant/updatetenant">Update Tenant</Link>
          <Link to="/admin/tenant/removetenant">Remove Tenant</Link>
          <Link to="/admin/tenant/viewtenant">View Tenant By ID</Link>
          <Link to="/admin/tenant/viewalltenant">View All Tenant</Link>
        </div>

        <button  className="dropdown-btn" onClick={togglebtn}>Booking
          <i className="fa fa-caret-down"></i>
        </button>
        <div className="dropdown-container">
          <Link to="/admin/booking/addbooking">Add Booking</Link>
          <Link to="/admin/booking/updatebooking">Update Booking</Link>
          <Link to="/admin/booking/deletebooking">Delete Booking</Link>
          <Link to="/admin/booking/viewbooking">View Booking By ID</Link>
          <Link to="/admin/booking/viewallbooking">View All Bookings</Link>
        </div>

        <button  className="dropdown-btn" onClick={togglebtn}>Flat
          <i className="fa fa-caret-down"></i>
        </button>
        <div className="dropdown-container">
          <Link to="/admin/flat/addflat">Add Flat</Link>
          <Link to="/admin/flat/updateflat">Update Flat</Link>
          <Link to="/admin/flat/removeflat">Delete Flat</Link>
          <Link to="/admin/flat/viewflat">View Flat By ID</Link>
          <Link to="/admin/flat/viewallflat">View All Flat</Link>
        </div>
      </div>

     </React.Fragment>
     
    );
}

export default AdminPage;