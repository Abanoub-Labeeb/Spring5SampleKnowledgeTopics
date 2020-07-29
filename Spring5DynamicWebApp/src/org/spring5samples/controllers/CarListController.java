package org.spring5samples.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.spring5samples.models.Car;

/**
 * Servlet implementation class CarListController
 */


@WebServlet("/CarList")
public class CarListController extends HttpServlet {
	/*
	* Will be called via the main URL/CarList 
	* you can change "/CarList" to "/" if you want this to be the main controller 
	* but in that case you have to define path for the other controllers
	* As there can not be several Main controllers
	*/
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Setting model as a request attribute to be used by the view 
		ArrayList<Car> cars = new  ArrayList<Car>();
		cars.add(new Car("Toyota", "Sedan"));
		cars.add(new Car("Mercedes", "4X4"));
		cars.add(new Car("Volkswagn", "Passat"));
		
		request.setAttribute("CarList", cars);
		
		//dispatching the request from the main controller to the CarList.jsp view
		request.getRequestDispatcher("CarList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
