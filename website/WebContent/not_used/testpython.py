#! /usr/bin/python

# To change this template, choose Tools | Templates
# and open the template in the editor.

__author__="xuan"
__date__ ="$Apr 10, 2010 9:37:42 PM$"

if __name__ == "__main__":
    print "Hello World";

from javax.servlet.http import HttpServlet
class testpython (HttpServlet):
    def doGet(self,request,response):
        self.doPost (request,response)
    def doPost(self,request,response):
        toClient = response.getWriter()
        response.setContentType ("text/html")
        toClient.write("Hello Python")
        toClient.write("It's cool~~")
