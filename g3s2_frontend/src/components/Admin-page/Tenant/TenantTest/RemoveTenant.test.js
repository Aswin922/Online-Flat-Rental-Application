import { render } from "@testing-library/react";
import RemoveTenant from "./../RemoveTenant";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Remove Tenant Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><RemoveTenant/></Router>,div);
    })
    it ("Rendered Remove Button",()=>{
        const {getByTestId}=render(<Router><RemoveTenant/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})