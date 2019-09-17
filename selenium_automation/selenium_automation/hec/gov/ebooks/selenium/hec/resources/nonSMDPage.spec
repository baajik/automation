Page Title: HECLoginPage

# Object Definitions
==================================================================================================================
non_smd_link								id								nonSMDRequest

title										xpath							//input[@name='title']
select_pi									xpath							//input[@type='radio']
submit										xpath							//input[@type='submit']

banner_content								xpath							//td[@class='bannercontent']


other_project								xpath							//input[@name='otherProject']
key_phrases									xpath							//input[@name='keyPhrases']
nasa_contract								xpath							//input[@name='nasaVehicleType']
enter_nasa_contract							xpath							//input[@name='contractGrantWbsNumber']
nasa_contract_title							xpath							//input[@name='fundedMdTitle']
funding_manager_name						xpath							//input[@name='fundingManagerName']
funding_manager_email						xpath							//input[@name='fundingManagerEmail']
abstract									id								abstractTextArea
save_cover_sheet							xpath							//input[@name='submit']
submit_cover_sheet							xpath							//input[@value='Submit Completed Cover Sheet']

nas_pleiades_low							xpath							//input[@name='sorRequestMachineHoursModel[0].lowNumberProcessors']
nas_pleiades_high							xpath							//input[@name='sorRequestMachineHoursModel[0].highNumberProcessors']
nas_pleiades_average						xpath							//input[@name='sorRequestMachineHoursModel[0].averegeNumberProcessors']
nas_pleiades_clock_hrs						xpath							//input[@name='sorRequestMachineHoursModel[0].wallClockHrs']
nas_pleiades_no_runs						xpath							//input[@name='sorRequestMachineHoursModel[0].numberOfRuns']
save_continue								xpath							//input[@value='Save and Continue']

sor_mem_req									xpath							//input[@name='summaryOfRequirementModel.memoryReq']
classified_data								xpath							//input[@name='summaryOfRequirementModel.scientificEngRsrchInfo']
sensitive_data								xpath							//input[@name='summaryOfRequirementModel.unclassifiedAndNonsensitive']
disaster_rec_level							xpath	
submit_sor									xpath							//input[@value='Submit Completed Summary of Requirement']

edit_objectives_code						id							    quadOne
objectives_usage							id								objective0
identify_code								id								code0
identify_category							id								category0
save_button									xpath							//button[@type='button']//span[@class='ui-button-text']

edit_quad_image								id								quadTwo
upload_image								id								uploadImage
image_caption								id								imgCaption

edit_key_milestone							id								quadThree
milestone_description						id								milestone0
milestone_month								id								milestone_month0
milestone_year								id								milestone_year0

edit_scientific								id								quadFour
scientific_text_area						id								impact
submit_quadchart							id								submitButton

acknowledge_final_submission				id								acknStatus
success_message								xpath						//div[@class='success']


logout										classname							signout
==================================================================================================================