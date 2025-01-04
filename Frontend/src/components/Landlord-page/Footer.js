import React from 'react';

function Footer()
{
    return(
        <>
        
        <div className='container-fluid' style={{position:"absolute",backgroundImage: "linear-gradient(15deg, #5680e9 0%, #5ab9ea 100%)"}}>

    <div className="row">
    <div className="col ">

    
      

      <ul className="list-unstyled">
        <li>
        <strong>CONTACT US</strong></li>
        <li>
         Email: elsintjose@gmail.com
        </li>
        <li>
            Mobile: 8547989876
        </li>
      </ul>

    </div>
    
    <div className="col ">

      <ul className="list-unstyled text-center">
      <li>
        <strong>FOLLOW US</strong></li>
        <li>
          <a className="text text-dark" href="#!"style={{textDecoration:"none"}}>Instagram</a>
        </li>
        <li>
          <a className="text text-dark" href="#!" style={{textDecoration:"none"}}>LinkedIn</a>
        </li>
        <li>
          <a className="text text-dark" href="#!"style={{textDecoration:"none"}}>Twitter</a>
        </li>
      </ul>

    </div>
  

    
    <div className="col ">

      <ul className="list-unstyled text-center">
      <li>
        <strong>OUR BRANCHES</strong></li>
        <li>
          Mumbai
        </li>
        <li>
          Jaipur
        </li>
        <li>
          Hyderabad
        </li>
      </ul>

    </div>
  
</div>

<hr/>

<div className=" text-center " ><p>© OnlineFlatRental: Group 2</p>
</div>

            
        </div>
        </>

    )
}

export default Footer;
