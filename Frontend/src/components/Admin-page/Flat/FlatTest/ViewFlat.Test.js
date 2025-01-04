import { render } from "@testing-library/react";
import ViewFlat from "./../ViewFlat";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("View Flat Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><ViewFlat/></Router>,div);
    })
    it ("Rendered View Button",()=>{
        const {getByTestId}=render(<Router><ViewFlat/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})