# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
from selenium import webdriver
import time

from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

driver = webdriver.Chrome('/Users/dhrdas/Downloads/chromedriver.exe')
driver.maximize_window()
driver.get('https://www.rahulshettyacademy.com/AutomationPractice/')
RadioButton1 = driver.find_element_by_xpath("//input[@value='radio1' and @name='radioButton']")
RadioButton2 = driver.find_element_by_xpath("//input[@value='radio2' and @name='radioButton']")
RadioButton3 = driver.find_element_by_xpath("//input[@value='radio3' and @name='radioButton']")
AutoCompleteInput = driver.find_element_by_id("autocomplete")
DropDownSelect = driver.find_element_by_id("dropdown-class-example")
CheckBox1 = driver.find_element_by_id("checkBoxOption1")
CheckBox2 = driver.find_element_by_id("checkBoxOption2")
CheckBox3 = driver.find_element_by_id("checkBoxOption3")

# Radio button selection
if RadioButton1.is_selected():
    RadioButton2.click()
else:
    RadioButton1.click()

# Drop Down selection
select = Select(DropDownSelect)
select.select_by_value('option1')
# Check Box selection
if CheckBox1.is_selected():
    CheckBox3.click()
else:
    CheckBox2.click()
# Autocomplete selection
CountryToSelect = 'India'
AutoCompleteInput.send_keys(CountryToSelect)
time.sleep(3)
AutoList = driver.find_elements(By.XPATH, "//li[@class='ui-menu-item']")
for i in AutoList:
    value = i.text
    print(value)
    if value == CountryToSelect:
        i.click()

time.sleep(5)
driver.close()
