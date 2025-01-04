import { render } from "@testing-library/react";
import AddUser from "./../AddUser";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Add User Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><AddUser/></Router>,div);
    })
    it ("Rendered Add Button",()=>{
        const {getByTestId}=render(<Router><AddUser/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})