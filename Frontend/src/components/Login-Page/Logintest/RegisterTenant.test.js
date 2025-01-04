import { render } from "@testing-library/react";
import RegisterTenant from "./../RegisterTenant";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("RegisterTenant Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><RegisterTenant/></Router>,div);
    })
    it ("Rendered Add Button",()=>{
        const {getByTestId}=render(<Router><RegisterTenant/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})