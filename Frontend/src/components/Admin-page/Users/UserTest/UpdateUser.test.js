import { render } from "@testing-library/react";
import UpdateUser from "./../UpdateUser";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Update User Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><UpdateUser/></Router>,div);
    })
    it ("Rendered Update Button",()=>{
        const {getByTestId}=render(<Router><UpdateUser/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})