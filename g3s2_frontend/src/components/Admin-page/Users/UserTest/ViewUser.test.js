import { render } from "@testing-library/react";
import ViewUser from "./../ViewUser";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("View User Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><ViewUser/></Router>,div);
    })
    it ("Rendered View Button",()=>{
        const {getByTestId}=render(<Router><ViewUser/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})