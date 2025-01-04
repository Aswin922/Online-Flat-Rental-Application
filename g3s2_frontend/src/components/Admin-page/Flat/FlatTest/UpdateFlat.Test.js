import { render } from "@testing-library/react";
import UpdateFlat from "./../UpdateFlat";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Update Flat Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><UpdateFlat/></Router>,div);
    })
    it ("Rendered Update Button",()=>{
        const {getByTestId}=render(<Router><UpdateFlat/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})