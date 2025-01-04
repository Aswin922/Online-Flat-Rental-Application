import ViewAllFlat from "./../ViewAllFlat";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("View All Flat Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><ViewAllFlat/></Router>,div);
    })
})