# Save Draft NOC
================
Created by erlan.beisen on 2019-08-08
table: resources/notice-of-overcharge/notice-of-overcharge.csv

# Save Draft NOC
----------------
tags: createNocForm

* Scenario/Row <scenario>

* Navigate to Notice of Overcharge Form page as GSA Auditor
* Fill Notice of Overcharge Form
* Click Save Draft button on Notice of Overcharge Form page
* Click Dashboard link
* Validate user is on Dashboard List page
* Validate NOC on Dashboard page
* Click on "Edit NOC" link on Dashboard page table
* Validate Notice of Overcharge Form Data
* Update Notice of Overcharge Form
* Click Submit button on Notice of Overcharge Form page
* Validate user is on NOC List page

temp- system should take user to NOC List after submit, but takes to Dashboard
* Click NOC List link

* Validate submitted NOC on NOC List page
___________________
* Delete NOC record
* Logout