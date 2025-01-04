import { render } from "@testing-library/react";
import ViewTenant from "./../ViewTenant";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("View Tenant Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><ViewTenant/></Router>,div);
    })
    it ("Rendered View Button",()=>{
        const {getByTestId}=render(<Router><ViewTenant/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})