import { render } from "@testing-library/react";
import UpdateTenant from "./../UpdateTenant";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Update Tenant Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
        ReactDOM.render(<Router><UpdateTenant/></Router>,div);
    })
    it ("Rendered Update Button",()=>{
        const {getByTestId}=render(<Router><UpdateTenant/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})