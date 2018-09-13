package com.controller;

import java.util.ArrayList;

import org.hibernate.validator.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javasrc.Registration;
import javasrc.Student;

@Controller
public class AdmissionController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] {"studentSkills"});
	}
	
	@RequestMapping(value = "/AdmissionForm.html" , method = RequestMethod.GET)
	public ModelAndView GetAdmissionForm() {
		
		ModelAndView model1 = new ModelAndView("AdmissionForm");
		return model1;
	}
	
	@RequestMapping(value= "/submitAdmissionForm.html" , method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentname") String name , @RequestParam("studenthobby") String hoby){
		ModelAndView model1 = new ModelAndView("AdmissionSucess");
		model1.addObject("msg", " detail submitted by" + name + " " + hoby);
		return model1;
		
	}
	
	
	@RequestMapping(value = "/AdmissionForm1.html" , method = RequestMethod.GET)
	public ModelAndView GetAdmissionForm1() {
		
		ModelAndView model1 = new ModelAndView("AdmissionForm1");
		return model1;
	}
	
	@RequestMapping(value = "/Home.html" , method = RequestMethod.GET)
	public ModelAndView Gethome() {
		
		ModelAndView model1 = new ModelAndView("Home");
		return model1;
	}
	
	
	// Registration
	
	@RequestMapping(value = "/Registration.html" , method = RequestMethod.GET)
	public ModelAndView GetRegistration() {
		
		ModelAndView model1 = new ModelAndView("Registration");
		return model1;
	}
	@RequestMapping(value= "/submitRegistration.html" , method = RequestMethod.POST)
	public ModelAndView submitRegistration(@ModelAttribute("registration1") Registration registration1, BindingResult results){
		if(results.hasErrors()){
			ModelAndView model1 = new ModelAndView("registration1");
			return model1;
		}
			ModelAndView model1 = new ModelAndView("RegistrationSucess");
			return model1;
		}
	
		
	//@RequestMapping(value= "/submitAdmissionForm1.html" , method = RequestMethod.POST)
//	public ModelAndView submitAdmissionForm1(@RequestParam("studentname") String name , @RequestParam("studenthobby") String hobby){
//		
//		Student student1 = new Student();
//		student1.setStudentname(name);
//		student1.setStudenthobby(hobby);@Valid
	
	@RequestMapping(value= "/submitAdmissionForm1.html" , method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm1(@ModelAttribute("student1") Student student1, BindingResult results){
		
		if(results.hasErrors()){
			ModelAndView model1 = new ModelAndView("AdmissionForm1");
			return model1;
		}
		
		ModelAndView model1 = new ModelAndView("AdmissionSucess1");
		return model1;
		
	}
	@ModelAttribute
	public void addingcommonobject(Model model1) {
		model1.addAttribute("headermessage", " This is my new Spring Mvc project for library management");
	}
	
	// This is a method used for webservice
	
	@ResponseBody
	@RequestMapping(value="/student", method= RequestMethod.GET)
	public ArrayList<Student> getStudentsList(){
		
		Student student1 = new Student();
		student1.setStudentname("Yohan");
		
		Student student2 = new Student();
		student2.setStudentname("Mintamir");
		
		Student student3 = new Student();
		student3.setStudentname("Our kid");
		
		ArrayList<Student> studentsList = new ArrayList<Student>();
		studentsList.add(student1);
		studentsList.add(student2);
		studentsList.add(student3);
		
		return studentsList;
	}
	
	

}




from os import environ
from at_pyspec import Spec, ExpectFn
#from views import Views
from lib.utils import *
from at_pyspec.utils.context import Context
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains
from utils.app_generic_lib import generic_lib
#from views.validated_form import ValidatedForm
from faker import Faker
import time
from lib.utils import *
from at_seleniumlib import PageObject
from selenium.webdriver.remote.webelement import WebElement
from at_pyspec import View
from faker import Faker
import time
from lib.utils import *
from at_seleniumlib import PageObject
from selenium.webdriver.remote.webelement import WebElement

import inspect

class Domains(View):
    @property
    def page_name(self):
        return self.__class__.__name__

    @property
    def root_element(self):
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(self.driver, "/html/body", By.XPATH, field_name, self.page_name)

    @property
    def is_active(self):
        return self.root_element.is_displayed()

    #def populate(self, party):
        #fake = Faker()
        #update_bs_form_field(self.domain_id, party.get("domain_id"))


    def domain_id(self,id):
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(self.root_element,"//*[@id='input-10001-1000101']",By.XPATH,field_name,self.page_name )


    @property
    def domain_name(self):
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(self.root_element, "input-10001-1000102", By.ID,field_name, self.page_name)

    @property
    def domain_search(self):
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(self.root_element, "//*[@id='search']", By.XPATH, field_name, self.page_name)

    @property
    def name_result(self):
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(
            self.root_element, '//*[@class="datatable table table-docupace dataTable no-footer dtr-inline"]/tbody/tr',
            By.XPATH, field_name, self.page_name)

    @property
    def user_result(self):
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(
            self.root_element, '//*[@id="table_2163_domain_300_table"]/tbody/tr[" + str(i) + "]/td[3]',
            By.XPATH, field_name, self.page_name)

    # datatable table table-docupace dataTable no-footer collapsed dtr-inline

    @property
    def next(self):
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(
            self.root_element,
            '//*[@id="table_8459_domain_300_table_next"]',By.XPATH, field_name, self.page_name)



    def user_result_value(self, role): # I want this to be variable, not needed
        if self.is_active:
            if self.user_result.text == role.get("role_name"):
                self.name_result.click()
            #if self.user_result.text == "ATHAgencyManager":
                #self.name_result.click()

    @property
    def name_result(self):
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(
            self.root_element,
            '//*[@class="datatable table table-docupace dataTable no-footer collapsed dtr-inline"]/tbody/tr',
            By.XPATH, field_name, self.page_name)

    @property
    def User(self):# This will used to get the text value of the User like manager
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(
            self.root_element,
            '//*[@class="datatable table table-docupace dataTable no-footer collapsed dtr-inline"]/tbody/tr/td[3]',
            By.XPATH, field_name, self.page_name)


    @property
    def click_on_user(self):
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(
            self.root_element,
            '//*[@class="datatable table table-docupace dataTable no-footer collapsed dtr-inline"]/tbody/tr/td[3]',
            By.XPATH, field_name, self.page_name)


    def user_name_result(self): # used to print the user value form user owned producer
        while self.next.is_enabled():
            for user in self.user_result():
                print(user)


    @property
    def click_On_Skills(self):
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(self.root_element,
                                            '//*[@id="main_view"]/domain/domain-edit/div/div/div[1]/div/ul/li[9]/a',
                                            By.XPATH, field_name,self.page_name)

    @property
    def skills(self):
        field_name = inspect.stack()[0][3]
        return generic_lib.wait_for_element(self.root_element,
                                            '//*[@id="table_2797_domain_840_table"]/tbody/tr["+ str(i) +"]/td[2]',
                                            By.XPATH, field_name,self.page_name)



    def get_skills(self):
        while self.next.is_enabled():
            i = 0
            for skill_lists in self.skills:
                i = i + 1
                print(skill_lists.text)




    '''
        def get_user_value(self):
            while self.next.is_enabled():
                i = 0
                for lists in self.user_result:
                    i = i + 1
                    print(lists.text)

                    if lists.text == ('NON-COMPLIANT' or 'PENDING'):
                        # print(lists.text)

                        for list1 in self.course_types(i):

                            lis = list1.text
                            print(lists.text, lis)
                if "pass" not in self.next.get_attribute("class"):
                    self.driver.execute_script("arguments[0].click();", self.next)
                else:
                    break

    '''






"""
User's Skill Information
"""
from os import environ
from at_pyspec import ExpectFn, Spec
from views import Views
from os import environ
from at_pyspec import Spec, ExpectFn
from views import Views
from at_pyspec.utils.context import Context
from at_pyspec.utils.context import Context
from os import environ
from at_pyspec import Spec, ExpectFn
from views import Views
from lib.utils import *
from at_pyspec.utils.context import Context

spec: Spec = Spec()
spec.name = "Docupace"
spec.description = ""
@spec.map_params
def map_params(data, **kwargs):
    from os import environ

    data_file = environ.get("Thia can be any thing", "test")
    scenarios = data.get(data_file)['Sheet1']
    spec.params = [x for x in scenarios if x['ID'] is not None]


@spec.setup
def setup(context: Context, **kwargs):
    pass

@spec.step("Login to Docupace with Manager Test User")
def step_1(expect: ExpectFn, views: Views, **kwargs):
    """

    :param expect:
    :param views:
    :param kwargs:
    """
    username = environ.get("MANAGER_USERNAME")
    password = environ.get("MANAGER_PASSWORD")
    if username != '' and username != None and password != '' and password != None:
        views.login_page.login(username, password)
    expect("Login Docupace application", "Login Successful")\
        .report_pass('Login successful and Docupace dashboard opens')


@spec.step("Administration-->List Domains")
def step_2(expect: ExpectFn, views: Views, **kwargs):
    """

    :param expect:
    :param views:
    :param kwargs:
    """
    views.home_page.click_administration()
    views.administration_page.click_list_domain()
    expect("List Domain should be clicked", 'Clicked').report_pass('Clicked')


@spec.step("Search for User Access in Name field and click the result")
def step_3(expect: ExpectFn, views: Views,param, **kwargs):
    """

    :param expect:
    :param views:
    :param kwargs:
    """
    # kwargs = {"name": "User Access"}
    name = "User Access"
    id = "300"
    party = param

    #views.domain.populate(party)
    expect("User ID searched", 'Clicked').report_pass('serached')
    views.domain.domain_search.click()
   # views.list_domain_page.search_name(name)
    #views.list_domain_page.click_name_result()
    expect("User Access should be clicked", 'Clicked').report_pass('Clicked')


@spec.step("Find a user with skill and click on that user")
def step_4(expect: ExpectFn, views: Views,param, **kwargs):
    """

    :param expect:
    :param views:
    :param kwargs:
    """
    user = param
    #user = param["Role"]
    with views.domain as dm:


        while dm.next.is_enabled():
            i = 1
            for user in dm.driver.find_elements_by_xpath('//*[@class="datatable table table-docupace dataTable no-footer collapsed dtr-inline"]'
                                                         '/tbody/tr[i]/td[3]'):
                i = i + 1
                #if user.text == user:
                    #print(user.text)
                if user.text == 'ATHContractManager':
                    print(user.text)
                    break
            if dm.next.is_enabled():
                views.domain.next.click()
            else:
                break

   # name = "ATHContractUser"
   # views.user_access_page.search_name(name)
    expect("User with skill should be selected", 'selected').report_pass('selected')

@spec.step("click on user field")
def step(expect:ExpectFn, views : Views, **kwargs):
    views.domain.click_on_user.click()
    expect("User with skill should be selected", 'clicked').report_pass('selected')



@spec.step("click on skills")
def step(expect:ExpectFn, views : Views, **kwargs):
    views.domain.click_On_Skills.click()
    expect("Click on skill", 'clicked').report_pass('clicked')


@spec.step("In Skill section verify All the fields")
def step_5(expect: ExpectFn, views: Views, **kwargs):
    """

    :param expect:
    :param views:
    :param kwargs:
    """
    with views.domain as dm:
        while dm.next.is_enabled():
            for skills in dm.skills():
                print(skills.text)
            if dm.next.is_enabled():
                views.domain.next.click()
            else:
                break
        expect("Click on skill", 'clicked').report_pass('clicked')



# newwwwwwww


from typing import List, Callable, Union
from abc import ABCMeta, abstractproperty
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.remote.webdriver import WebDriver
from selenium.webdriver.remote.webdriver import WebElement
from selenium.webdriver.support.ui import WebDriverWait
from at_seleniumlib.frames import FrameTransition, get_current_frame
from selenium.webdriver.common.action_chains import ActionChains


def wait_for_active_view(driver, view, timeout: int = 10, on_fail=None):
    if on_fail is None:
        def on_fail():
            pass

    try:
        WebDriverWait(driver, timeout) \
            .until(lambda d: view.is_active is True)
    except TimeoutException:
        on_fail()


def wait_for_inactive_view(driver, view, timeout: int = 10, on_fail=None):
    if on_fail is None:
        def on_fail():
            pass

    try:
        WebDriverWait(driver, timeout) \
            .until(lambda d: view.is_active is False)
    except TimeoutException:
        on_fail()


class PageObject(metaclass=ABCMeta):
    """
    Views are an implementation of the page object pattern

    :param driver: Webdriver instance
    :param parent: Used for advanced sub-querying
    """

    frames = []

    def __init__(
        self,
        driver: WebDriver,
        parent=None
    ):
        self.driver = driver
        self.parent = parent
        self._frame_transitioner: FrameTransition =\
            FrameTransition(self.driver, self.frames)

    def __enter__(self):
        self._frame_transitioner.enter_frames()
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        self._frame_transitioner.exit_frames()

    @property
    def current_frame(self):
        return get_current_frame(self.driver)

    @abstractproperty
    def is_active(self) -> bool:
        """
        The view is active on screen?

        :return: Boolean
        """
        raise NotImplementedError

    @property
    def root_element(self) -> WebElement:
        """
        Root element of the view

        :return: WebElement
        """
        raise self.driver.find_element_by_tag_name("body")

    @property
    def inner_html(self):
        return self.root_element.get_attribute("innerHTML")

    @property
    def outer_html(self):
        return self.root_element.get_attribute("outerHTML")

    def wait_until_active(self, timeout: int = 10, on_fail=None):
        """
        Halt execution until view becomes active

        :param timeout: Seconds until TimeoutException is raised. (Default: 10)
        :param on_fail: Callable to call on timeout
        :return:
        """
        wait_for_active_view(self.driver, self, timeout, on_fail)

    def wait_until_inactive(self, timeout: int = 10, on_fail=None):
        """
        Halt execution until view becomes inactive

        :param timeout: Seconds until TimeoutException is raised. (Default: 10)
        :param on_fail: Callable to call on timeout
        :return:
        """
        wait_for_inactive_view(self.driver, self, timeout, on_fail)

    def get_link_with_text(self, text) -> WebElement:
        """
        Get first link matching text inside the view

        This is a shortcut method using the view's root_element for query scope
        :param text: Text to match
        :return: WebElement of link
        """
        if not hasattr(self, 'root_element'):
            raise RuntimeError('root_element is not defined')
        return self.root_element.find_element_by_link_text(text)

    def get_link_with_partial_text(self, text):
        if not hasattr(self, 'root_element'):
            raise RuntimeError('root_element is not defined')
        return self.root_element.find_element_by_partial_link_text(text)

    def has_link_with_text(self, text) -> bool:
        """
        Return if view has link with text
        :param text: Text to match
        :return: Bool if link exists
        """
        try:
            self.get_link_with_text(text)
            return True
        except BaseException:
            return False

    def has_link_with_partial_text(self, text) -> bool:
        """
        Return if view has link with text
        :param text: Text to match
        :return: Bool if link exists
        """
        try:
            self.get_link_with_partial_text(text)
            return True
        except BaseException:
            return False

    def click_link_with_text(self, text):
        """
        Click link with text inside the view
        :param text:
        :return:
        """
        self.get_link_with_text(text).click()

    def click_link_with_partial_text(self, text):
       # self.get_link_with_partial_text(text).click()
        ActionChains(self.driver).move_to_element(self.get_link_with_text(text)).click().perform()


class PageObjectTree(object):
    def __init__(self, driver: WebDriver = None):
        self.driver = driver










from os import environ
from at_pyspec import Spec, ExpectFn
from views import Views
from lib.utils import *
from at_pyspec.utils.context import Context
spec: Spec = Spec()
spec.description = "Verify either the right picture which matches the name clicked or not"
start_time = time()

@spec.map_params
def map_params(data, **kwargs):
    #from os import environ

    data_file = environ.get("AGENTS_FILE", "agents")
    scenarios = data.get(data_file)['can_sell']
    spec.params = [x for x in scenarios if x['ID'] is not None]

@spec.setup
def setup(context: Context, **kwargs):
    """
    Launch Application
    """
    Context.correc_answeras_lists = []

@spec.setup
def setup(views: Views,data, **kwargs):
    # Go to DCM
    url = data.get("agents")["Config"]
    dcm_url = url[0]
    views.driver.get(dcm_url['DCM_URL'])

#@spec.step("clicking on the picture and verify the name")
@spec.step("verify in which picture it is located")
@spec.step("Get the requested name")
def step(expect: ExpectFn, views: Views, **kwargs):

    with views.name_game as cs:
        i = 0
        for individual_name in cs.all_picture:
            i = i + 1
            if individual_name.text == cs.name_of_your_friend.text:
                expect("This is the name of your friend requested to match with the picture ",
                       cs.name_of_your_friend.text).report_pass(cs.name_of_your_friend.text)
                expect("individual_name is located in picture ", cs.pic_value(i).text).report_pass(cs.pic_value(i).text)
                print(individual_name.text + " is located in picture  " + cs.pic_value(i).text)
                sleep(2)
                # Verify the if the system clicked on the correct picture or not
                cs.pic_value(i).click()
                sleep(3)
                print("After clicking on the picture the name extracted is " + individual_name.text + "and it is located in picture  " + cs.pic_value(i).text )
                sleep(5)
                break


        #len(cs.all_picture)
# run the script 20 times and get the number of trials, correct answear and Strike
@spec.step("Get the total number of attempts for each player")
def step(expect: ExpectFn, views: Views, **kwargs):

    for m in range(1,21):
        with views.name_game as cs:
            sleep(2)
            #for i in range(1,6):
            i = 0
            for individual_name in cs.all_picture:
                i = i + 1
                cs.each_picture(i).click()
                if individual_name.text == cs.name_of_your_friend.text:
                    print(individual_name.text,cs.each_picture(i).text)
                    break
        expect("This is the name of your friend requested to match with the picture ",
               cs.name_of_your_friend.text).report_pass(cs.name_of_your_friend.text)
        expect("Individual_name is located in picture ", cs.pic_value(i).text).report_pass(cs.pic_value(i).text)


@spec.step("Get the total number of attempts for each player")
def step(expect: ExpectFn, views: Views, **kwargs):

    with views.name_game as cs:
        expect("Total number of trial ", cs.number_of_tries.text).report_pass(cs.number_of_tries.text)
        expect("Total number of correct answear ", cs.correct_anwear.text).report_pass(cs.correct_anwear.text)
        expect("Total number of Strike ", cs.correct_anwear.text).report_pass(cs.correct_anwear.text)

































'''

clean code

@spec.step("Click on picture one")
def step(expect: ExpectFn, views: Views, **kwargs):

    with views.name_game as cs:
        sleep(2)

        i = 0
        for individual_name in cs.all_picture:
            i = i + 1
            if individual_name.text == cs.name_of_your_friend.text:
                expect("This is the name of your friend requested to match with the picture ",
                       cs.name_of_your_friend.text).report_pass(cs.name_of_your_friend.text)
                expect("individual_name is located in picture ", cs.pic_value(i).text).report_pass(cs.pic_value(i).text)
                print(individual_name.text + " is located in picture  " + cs.pic_value(i).text)
                sleep(2)
                # Verify the if the system clicked on the correct picture or not
                cs.pic_value(i).click()
                print("After clicking on the picture the name extracted is " + individual_name.text + "and it is located in picture  " + cs.pic_value(i).text )
                sleep(5)
                #print("The number value is " + cs.pic_value(i).text)
                #cs.pic_value(i).click()


 i = 0
        for individual_name in cs.all_picture:
            i = i + 1
            if individual_name.text == cs.name_of_your_friend.text:
                print(individual_name.text + " is located in picture  " + cs.pic_value(i).text)
                sleep(2)
                # Verify the if the system clicked on the correct picture or not
                cs.pic_value(i).click()
                print("After clicking on the picture the name extracted is " + individual_name.text + "and it is located in picture  " + cs.pic_value(i).text )
                sleep(50)
                #print("The number value is " + cs.pic_value(i).text)
                #cs.pic_value(i).click()




i = 1
        while cs.correct_anwear.text != "1":
                cs.driver.find_element_by_xpath("//*[@id='gallery']/div/div[" + str(i) + "]/div[1]").click()
                if cs.correct_anwear.text == i:
                    pass
                else:
                    i = i + 1










This is for the pictures
i = 0
        for trials in cs.driver.find_elements_by_xpath(
                                "//*[@id='gallery']/div/div[" + str(i) + "]/div[1]"):
            trials.click()




#cs.click_on_pic_1
        #expect("Picture one clicked link clicked", '').report_pass()
        sleep(2)

        i = 0
        #for i in cs.driver.find_elements_by_xpath("//*[@id='stats']/span[" + str(i) +"]"):
            #print(i)

        #for trials in cs.driver.find_elements_by_xpath(
                              #  "//*[@id='gallery']/div/div[" + str(i) + "]/div[1]"):
            #trials.click()
            #i = i + 1
            #print(trials.text)
        correc_answeras_lists = []
        for correc_answeras in cs.driver.find_elements_by_xpath("//*[@id='stats']/span[" + str(i) +"]"):
            i = i + 1
            Context.correc_answeras_lists.appened(correc_answeras.text)
            print(correc_answeras_lists)





        if cs.correct_anwear.text == 0:
            i = 0
            for trials in cs.driver.find_elements_by_xpath(
                                "//*[@id='gallery']/div/div[" + str(i) + "]/div[1]"):
                trials.click()
                if cs.correct_anwear.text != 0:
                    break
                else:
                    for trials in cs.driver.find_elements_by_xpath(
                                            "//*[@id='gallery']/div/div[" + str(i) + "]/div[1]"):
                        trials.click()
                        
                        
                        
                        
                        
                        
i = 0
        for i in cs.driver.find_elements_by_xpath(
                                "//*[@id='gallery']/div/div[" + str(i) + "]/div[1]"):

            i = i + 1
            i.click()
            print("The correct answear in each itration is " + cs.correct_anwear.text)

        cs.number_of_tries.text
        print("The number of trial is " + cs.number_of_tries.text)
        sleep(2)
        
        
        
        
           # print("All pictures clicked " + i.text)
        print(len(cs.all_picture))
        i = 0
        while i < len(cs.all_picture):
            for items in cs.driver.find_elements_by_xpath("//*[@id='gallery']/div/div[" + str(i) + "]/div[1]"):
               # items.click()
                print(items.text)
                i = i + 1
                print(items.text)
            #cs.all_picture[i].click()

                #print("All pictures clicked ")

'''
		       
		       
		       
		       
		       
		       
		       
		       
		       
		       
spec





from views.validated_form import ValidatedForm
from faker import Faker
import time
from lib.utils import *
from at_seleniumlib import PageObject
from selenium.webdriver.remote.webelement import WebElement


class NameGame(PageObject):
    #frames = ["container"]

    @property
    def root_element(self):
        return self.driver.find_element_by_tag_name("body")

    @property
    def is_active(self):
        return self.root_element.is_displayed()

    @property
    def picture_one(self):
        return WebDriverWait(self.driver ,10).until(EC.presence_of_element_located ((By.XPATH,"//*[@id='gallery']/div/div[1]/div[1]")))

    @property
    def name_of_your_friend(self):
        return WebDriverWait(self.driver, 10).until(EC.presence_of_element_located ((By.XPATH, "//*[@id='name']")))

    @property
    def picture_one(self)-> WebElement:
        return WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.XPATH, "//*[@id='gallery']/div/div[1]/div[2]")))

    @property
    def picture_two(self):
        return WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.XPATH, "//*[@id='gallery']/div/div[2]/div[2]")))

    @property
    def picture_three(self):
        return WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.XPATH, "//*[@id='gallery']/div/div[3]/div[2]")))

    @property
    def picture_four(self):
        return WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.XPATH, "//*[@id='gallery']/div/div[4]/div[2]")))

    @property
    def picture_five(self):
        return WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.XPATH, "//*[@id='gallery']/div/div[5]/div[2]")))

    @property
    def all_picture(self)-> WebElement:
        #return WebDriverWait(self.driver, 10).until(EC.presence_of_all_elements_located ((By.XPATH, "//*[@id='gallery']/div/div[" + str(i) + "]/div[2]")))
        return self.driver.find_elements_by_xpath("//*[@id='gallery']/div/div/div[2]")


    def each_picture(self,i) -> WebElement:
        return WebDriverWait(self.driver, 10).until(EC.presence_of_element_located((By.XPATH,"//*[@id='gallery']/div/div["+ str(i) + "]/div[1]")))
        #return self.driver.find_element_by_xpath("//*[@id='gallery']/div/div[" + str(i) + "]/div[1]")

    def pic_value(self,i)->WebElement:
        return self.driver.find_element_by_xpath("//*[@id='gallery']/div/div[" + str(i) + "]/div[1]")

        #images = self.driver.find_elements_by_tag_name('img')
        #return images
        #return WebDriverWait(self.driver, 10).until(EC.presence_of_element_located ((By.XPATH, "//*[@id='gallery']/div/div/div[2]")))
        #all_pic =  self.driver.find_element_by_xpath("//*[@id='gallery']/div/div/div[2]")

        #return self.driver.execute_script("arguments[0].click();", all_pic)

    def click_on_pic_1(self):
        return self.picture_one.clcik()

    @property
    def correct_anwear(self):
        return WebDriverWait(self.driver, 10).until(EC.presence_of_element_located ((By.XPATH, "//*[@id='stats']/span[2]")))

    @property
    def number_of_tries(self):
        return WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.XPATH, "//*[@id='stats']/span[1]")))


    @property
    def results_after_click(self):
        return WebDriverWait(self.driver, 10).until(EC.presence_of_all_elements_located ((By.XPATH, "//*[@id='stats']")))



cansell





from os import environ
from at_pyspec import Spec, ExpectFn
from views import Views
from lib.utils import *
from at_pyspec.utils.context import Context
spec: Spec = Spec()
spec.name = "Can Sell"
spec.description = ""
start_time = time()

@spec.map_params
def map_params(data, **kwargs):
    #from os import environ

    data_file = environ.get("AGENTS_FILE", "agents")
    scenarios = data.get(data_file)['can_sell']
    spec.params = [x for x in scenarios if x['ID'] is not None]

@spec.setup
def setup(context: Context, **kwargs):
    """
    Launch Application
    """
    # Status captured
    context.status = []
    context.course_type_lists = []
    context.lis1 = []


@spec.setup
def setup(views: Views,data, **kwargs):
    # Go to DCM
    url = data.get("agents")["Config"]
    dcm_url = url[0]
    views.driver.get(dcm_url['DCM_URL'])

    username = environ.get("USERNAME")
    password = environ.get("PASSWORD")

    # Login
    views.login.login(username, password)

@spec.step("Click on party link")
def step(expect: ExpectFn, param , views: Views, **kwargs):

    with views.click_on_party_link as cs:
        sleep(5)
        cs.party_link.click()
        expect("Party Id link clicked", '').report_pass()


@spec.step("Click on Can sell link")
def step(expect:ExpectFn, param, views:Views, **kwargs):
    party = param
    with views.click_on_can_sell_link as csl:
        sleep(3)
        csl.can_sell_link.click()
        expect("Can sell link clicked", '').report_pass()


@spec.step("Search party name")
def step(expect: ExpectFn, param , views: Views, **kwargs):
    party = param
    with views.fill_serach as fs:
        sleep(2)
        fs.populate(party)
        expect("Search party name", '').report_pass()
        sleep(1)
        fs.click_on_search.click()
        expect("Clicked on search button", '').report_pass()
        sleep(2)

@spec.step("Click on Recalculate Compliance button")
def step(expect: ExpectFn, param , views: Views,context, **kwargs):
    party = param
    list1 = param
    with views.recalculate_compliance as rc:
        sleep(3)
        rc.click_on_recalculate_compliance.click()
        expect("Recalculate compliance button clicked", "").report_pass()
        sleep(4)
        rc.click_on_popup.click()
        expect("Popup Clicked", "").report_pass()
        sleep(3)



@spec.step("Click on Recalculate Compliance button")
def step(expect: ExpectFn, param, views: Views, context, **kwargs):
    with views.find_Lists_Of_Courses as fls:



    #def check_status_list(self):
        while fls.next.is_enabled():
            i = 0
            for course_status in fls.status_list:
                i = i + 1
                if course_status.text == ('NON-COMPLIANT' or 'PENDING'):
                    # print(lists.text)
                    sleep(2)
                    course_type_lists = []
                    for course_types in fls.driver.find_elements_by_xpath(
                                            "//*[@id='Grid_Person_Main_CanSell']/tbody/tr[" + str(i) + "]/td[1]"):
                        sleep(2)
                        course_type_lists.append(course_types.text)
                        course_type_lists = ''.join(course_type_lists)
                        print(course_status.text, course_type_lists)

            if "pass" not in fls.next.get_attribute("class"):
                sleep(2)
                fls.driver.execute_script("arguments[0].click();", fls.next)
            else:
                break

    @spec.step("Click on Continuing Edu link")
    def step(expect: ExpectFn, param, views: Views, context, **kwargs):
        with views.create_new_cont_ed_credit_link as cel:
            sleep(2)
            cel.continuing_education_Link.click()
            expect("Continuing Edu link clicked", '').report_pass()
            # sleep(5)
            # csl.course_type.click()
        party = param

        with views.create_new_count_ed_credit_button as cedb:
            sleep(2)
            cedb.click_on_create_new_count_ed_credit.click()
            expect("Clicked on Create new cont education credit", '').report_pass()
            sleep(2)

        # ("fill continuing education form, Search For Course")
        with views.fill_contining_edu_form as fcef:
            # -------------------
            party = param
            sleep(2)
            fcef.populate_fill_page(party)
            sleep(2)
            expect("Populated a course completion date of todays date", '').report_pass()
            sleep(2)
            fcef.click_on_search_for_course_link.click()
            expect("Clicked on countinuing education credit", '').report_pass()
            sleep(2)
        #print(lis)
        # ("fill_contining_edu_form piker page")
        with views.search_course_piker_page as scpp:
            party = param
            #list2 = param
            scpp.populate1(party)
            expect("Sortted by Manual", '').report_pass()
            sleep(2)
                #print(lists.text, list1.text)


            scpp.populate(course_type_lists)


            expect("Course name provided", '').report_pass()
            sleep(2)

            scpp.search_course_name_but.click()
            expect("Search button clicked", '').report_pass()
            sleep(2)
            scpp.select()
            expect("Select Button clicked", '').report_pass()
            sleep(2)

            # @spec.step(" Validate and Save")
        with views.fill_contining_edu_form as fcef:
            sleep(2)
            fcef.validate()
            expect("Validation sucessfuly", 'VALIDATING...SUCCESSFUL').report_pass()
            sleep(2)
            fcef.save()
            sleep(3)





'''
@spec.step("List out the courses")
def step(expect: ExpectFn, param , context, views: Views, **kwargs):
    #status = param
    with views.find_Lists_Of_Courses as fls:
        sleep(2)

        while fls.next.is_enabled():
            i = 0
            for lists in fls.status_list:
                i = i + 1
                if lists.text ==('NON-COMPLIANT' or 'PENDING'):
                    print(lists.text)
                    # print(lists.text)
                    sleep(2)
                    for list_of_courses in fls.course_types:
                        sleep(2)
                        print(list_of_courses.text)
            if "pass" not in fls.next.get_attribute("class"):
                sleep(2)
                fls.driver.execute_script("arguments[0].click();", fls.next)
            else:
                break


'''
'''
#@spec.step("Click on Continuing Edu link Side bar")
#def step(expect: ExpectFn, param, views: Views, **kwargs):
    #party = param
    with views.create_new_cont_ed_credit_link as cel:
        sleep(2)
        cel.continuing_education_Link.click()
        expect("Continuing Edu link clicked", '').report_pass()
        # sleep(5)
        # csl.course_type.click()
    party = param

    with views.create_new_count_ed_credit_button as cedb:
        sleep(2)
        cedb.click_on_create_new_count_ed_credit.click()
        expect("Clicked on Create new cont education credit", '').report_pass()
        sleep(2)

    # ("fill continuing education form, Search For Course")
    with views.fill_contining_edu_form as fcef:
        # -------------------
        party = param
        sleep(2)
        fcef.populate_fill_page(party)
        sleep(2)
        expect("Populated a course completion date of todays date", '').report_pass()
        sleep(2)
        fcef.click_on_search_for_course_link.click()
        expect("Clicked on countinuing education credit", '').report_pass()
        sleep(2)
    #print(lis)
    # ("fill_contining_edu_form piker page")
    with views.search_course_piker_page as scpp:
        party = param
        scpp.populate1(party)
        expect("Sortted by Manual", '').report_pass()
        sleep(2)
            #print(lists.text, list1.text)

        scpp.populate(lis)


        expect("Course name provided", '').report_pass()
        sleep(2)

        scpp.search_course_name_but.click()
        expect("Search button clicked", '').report_pass()
        sleep(2)
        scpp.select()
        expect("Select Button clicked", '').report_pass()
        sleep(2)

        # @spec.step(" Validate and Save")
        with views.fill_contining_edu_form as fcef:
            sleep(2)
            fcef.validate()
            expect("Validation sucessfuly", 'VALIDATING...SUCCESSFUL').report_pass()
            sleep(2)
            fcef.save()
            sleep(3)


'''




