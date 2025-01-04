import ViewAllTenant from "./../ViewAllTenant";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("View All Tenant Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><ViewAllTenant/></Router>,div);
    })
})