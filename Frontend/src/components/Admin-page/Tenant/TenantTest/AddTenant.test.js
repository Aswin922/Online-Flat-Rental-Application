import { render } from "@testing-library/react";
import AddTenant from "./../AddTenant";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Add Tenant Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><AddTenant/></Router>,div);
    })
    it ("Rendered Add Button",()=>{
        const {getByTestId}=render(<Router><AddTenant/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})