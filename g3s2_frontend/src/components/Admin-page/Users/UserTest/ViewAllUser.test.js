import ViewAllUser from "./../ViewAllUser";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("View All User Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><ViewAllUser/></Router>,div);
    })
})