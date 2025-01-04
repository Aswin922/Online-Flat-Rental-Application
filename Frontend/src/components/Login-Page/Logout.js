import{useNavigate} from 'react-router-dom';

function Logout()
{
    function preback()
    {
      window.history.forward();
    }
    setTimeout(preback(),0);
  
    window.onunload=()=>(null);

    sessionStorage.clear()
    
    const history=useNavigate()
    history.push('/login')
    
    return (
        <></>
    )
}

export default Logout;