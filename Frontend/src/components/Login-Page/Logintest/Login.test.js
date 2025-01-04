import { render } from "@testing-library/react";
import Login from "./../Login";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Login Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><Login/></Router>,div);
    })
    it ("Rendered Add Button",()=>{
        const {getByTestId}=render(<Router><Login/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})