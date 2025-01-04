import ViewAllLandlord from "./../ViewAllLandlord";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("View All Landlord Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><ViewAllLandlord/></Router>,div);
    })
})