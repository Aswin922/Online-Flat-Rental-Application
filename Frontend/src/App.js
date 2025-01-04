import './App.css';

import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route} from "react-router-dom"

import Home from './components/Home-Page/Home';
import Login from './components/Login-Page/Login';
import RegisterLandlord from './components/Login-Page/RegisterLandlord.js';
import RegisterTenant from './components/Login-Page/RegisterTenant';
import NotFoundPage from './components/NotFoundPage';
 
import AdminPage from './components/Admin-page/AdminPage/AdminPage';
import LandLord from './components/Landlord-page/LandlordPage';
import Tenant from './components/Tenant-page/TenantPage';

import AddUser from './components/Admin-page/Users/AddUser';
import ViewAllUser from './components/Admin-page/Users/ViewAllUser';
import RemoveUser from './components/Admin-page/Users/RemoveUser';
import ViewUser from './components/Admin-page/Users/ViewUser';
import UpdateUser from './components/Admin-page/Users/UpdateUser';

import UpdateLandlord from './components/Admin-page/Landlord/UpdateLandlord';
import ViewLandlord from './components/Admin-page/Landlord/ViewLandlord';
import ViewAllLandlord from './components/Admin-page/Landlord/ViewAllLandlord';
import RemoveLandlord from './components/Admin-page/Landlord/RemoveLandlord';
import AddLandlord from './components/Admin-page/Landlord/AddLandlord';


import ViewAllBooking from './components/Admin-page/Booking/ViewAllBooking';
import ViewBooking from './components/Admin-page/Booking/ViewBooking';
import RemoveBooking from './components/Admin-page/Booking/RemoveBooking';
import AddBooking from './components/Admin-page/Booking/AddBooking';
import UpdateBooking from './components/Admin-page/Booking/UpdateBooking';

import ViewAllTenant from './components/Admin-page/Tenant/ViewAllTenant';
import AddTenant from './components/Admin-page/Tenant/AddTenant';
import RemoveTenant from './components/Admin-page/Tenant/RemoveTenant';
import UpdateTenant from './components/Admin-page/Tenant/UpdateTenant';
import ViewTenant from './components/Admin-page/Tenant/ViewTenant';

import ViewAllFlat from './components/Admin-page/Flat/ViewAllFlat';
import AddFlat from './components/Admin-page/Flat/AddFlat';
import ViewFlat from './components/Admin-page/Flat/ViewFlat';
import RemoveFlat from './components/Admin-page/Flat/RemoveFlat';
import UpdateFlat from './components/Admin-page/Flat/UpdateFlat';

import LHome from './components/Landlord-page/LHome';
import LUpdateFlat from './components/Landlord-page/flat/LUpdateFlat';
import LInfo from './components/Landlord-page/LInfo';
import LAddFlat from './components/Landlord-page/flat/LAddFlat';
import LAllFlat from './components/Landlord-page/flat/LAllFlat';

import THome from './components/Tenant-page/THome';
import TInfo from './components/Tenant-page/TInfo';
import TGetAllFlats from './components/Tenant-page/TGetAllFlats';
import TViewFlatByBid from './components/Tenant-page/TViewFlatByBid';
import TUpdateBooking from './components/Tenant-page/TUpdateBooking';
import TAddFlatBooking from './components/Tenant-page/TAddFlatBooking';

function App() {
  return (

    <Router>

      <Routes>
        <Route exact path="/" element={<Home />}/>
        <Route path="/login" element={<Login />}/>
        <Route exact path="/admin" element={<AdminPage />}/>
        <Route exact path="/tenant" element={<Tenant />}/>
        <Route exact path="/landlord" element={<LandLord />}/>
        <Route path="/registerTenant" element={<RegisterTenant />}/>
        <Route path="/registerLandlord" element={<RegisterLandlord />}/>

        <Route path="/admin/user/adduser" element={<AddUser/>}/>
        <Route path="/admin/user/viewalluser" element={<ViewAllUser />}/>
        <Route path="/admin/user/removeuser" element={<RemoveUser />}/>
        <Route path="/admin/user/updateuser" element={<UpdateUser />}/>
        <Route path="/admin/user/viewuser" element={<ViewUser />} />   
        
        <Route path="/admin/landlord/addlandlord" element={<AddLandlord />}/>       
        <Route path="/admin/landlord/removelandlord" element={<RemoveLandlord />}/>       
        <Route path="/admin/landlord/updatelandlord" element={<UpdateLandlord />}/>        
        <Route path="/admin/landlord/viewlandlord" element={<ViewLandlord />}/>        
        <Route path="/admin/landlord/viewAllLandlord" element={<ViewAllLandlord />}/>        

        <Route path="/admin/tenant/addtenant" element={<AddTenant />}/>        
        <Route path="/admin/tenant/removetenant" element={<RemoveTenant />}/>        
        <Route path="/admin/tenant/updatetenant" element={<UpdateTenant />}/>        
        <Route path="/admin/tenant/viewtenant" element={<ViewTenant />}/>       
        <Route path="/admin/tenant/viewAlltenant" element={<ViewAllTenant />}/>         

        <Route path="/admin/booking/addbooking" element={<AddBooking />}/>        
        <Route path="/admin/booking/deletebooking" element={<RemoveBooking />}/>        
        <Route path="/admin/booking/updatebooking" element={<UpdateBooking />}/>       
        <Route path="/admin/booking/viewbooking" element={<ViewBooking />}/>      
        <Route path="/admin/booking/viewAllbooking" element={<ViewAllBooking />}/>         

        <Route path="/admin/flat/addflat" element={<AddFlat />}/>        
        <Route path="/admin/flat/removeflat" element={<RemoveFlat />}/>        
        <Route path="/admin/flat/updateflat" element={<UpdateFlat />}/>        
        <Route path="/admin/flat/viewflat" element={<ViewFlat />}/>          
        <Route path="/admin/flat/viewAllflat" element={<ViewAllFlat />}/> 

        <Route path='/landlord/info' element={<LInfo />}/>
        <Route path='/landlord/home' element={<LHome />}/>
        <Route path='/landlord/addFlat' element={<LAddFlat />}/>
        <Route path='/landlord/allFlat' element={<LAllFlat />}/>
        <Route path='/landlord/updateFlat' element={<LUpdateFlat/>}/>

        <Route path="/tenant/tenant" element={<THome />} />
        <Route path='/tenant/info' element={<TInfo />}/>
        <Route path="/tenant/getallflats"  element={<TGetAllFlats />} />
        <Route path="/tenant/viewflatbybid" element={<TViewFlatByBid />} />
        <Route path="/tenant/updatebooking"  element={<TUpdateBooking />} />
        <Route path="/tenant/addbooking"  element={<TAddFlatBooking />} />

        <Route element={<NotFoundPage />}/>
      </Routes>

    </Router>

  );
}

export default App;
