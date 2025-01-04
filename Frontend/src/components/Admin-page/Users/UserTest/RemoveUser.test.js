import { render } from "@testing-library/react";
import RemoveUser from "./../RemoveUser";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Remove User Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><RemoveUser/></Router>,div);
    })
    it ("Rendered Remove Button",()=>{
        const {getByTestId}=render(<Router><RemoveUser/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})