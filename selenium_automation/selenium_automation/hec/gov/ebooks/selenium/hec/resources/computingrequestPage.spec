Page Title: ComputingRequestPage

# Object Definitions
==================================================================================================================
computing_request							xpath							//div[@title='Computing Request']//span[@class='widget-title']
start_new_request							xpath							//span[@class='test action-link-text']
request_form								id								globalModal_wnd_title

roses										id								phase1RequestTypeForm_phase1RequestDTO_proposalTypeROSES
non_roses									id								phase1RequestTypeForm_phase1RequestDTO_proposalTypeDIRECTED
submit_request								id								requestTypeSubmit

view_page_close								xpath							//span[@class='k-icon k-i-close']

user_name									xpath							//div[@class='name nav']
logout										id								dashboardLogoutButton
project_banner								xpath							//div[@class='computing-request-window k-window-content k-content']//div[@class='banner-title']
project_banner_eligibilty					xpath							//div[@class='banner-title']//div				
									
cover_sheet									xpath							//span[@title='Update Cover Sheet']//span[@class='action-link-text']
summary_of_req								xpath							//span[@title='Update Summary Of Requirements']//span[@class='action-link-text']
quad_chart									xpath							//span[@title='Update Quad Chart']//span[@class='action-link-text']
final_submission							xpath                           //span[@title='Update Final Submission']//span[@class='action-link-text']
final_submission_ack						id								fsCheckbox
final_submission_send_email					id								finalSubmissionForm_sendEmail
submit_computing_request					id								finalSubmit

preferred_location							xpath							//span[@title='Preferred Location']//span[@class='k-input']
preferred_location_data						xpath							//div[@class='k-animation-container']//div[@id='location-list']//li[@data-offset-index='2']
key_phrases									xpath							//input[@name='coverSheetDTO.keyPhrases']
nasa_contract_select						id								coverSheetForm_coverSheetDTO_contractTypeNASA_CONTRACT
nasa_contract_text							xpath							//input[@name='coverSheetDTO.nasaContractGrantWbsNumber']
abstract									id								coverSheetForm_coverSheetDTO_requestAbstractDTO_abstractText
save_cover_sheet							xpath							//button[@class='button-icon save-button']
submit_cover_sheet							xpath							//button[@class='button-icon submit-button']

obj_of_usage								xpath							//li[@class='objective-container']//input[@id='quadChartForm_quadChartDTO_objectivesDTOList_0__objective']
obj_of_usage_2nd							xpath							//li[@class='objective-container']//input[@id='quadChartForm_quadChartDTO_objectivesDTOList_1__objective']
code_name									id								quadChartForm_quadChartDTO_codesDTOList_0__code
code_name_2nd								id 								quadChartForm_quadChartDTO_codesDTOList_1__code
category									id								quadChartForm_quadChartDTO_codesDTOList_0__categ
category_2nd								id								quadChartForm_quadChartDTO_codesDTOList_1__categ
key_milestone								id								quadChartForm_quadChartDTO_milestonesDTOList_0__milestone
key_mile_month								id								quadChartForm_quadChartDTO_milestonesDTOList_0__milestoneMonth
key_mile_year								id								quadChartForm_quadChartDTO_milestonesDTOList_0__milestoneYear
scientific_impact							id								quadChartForm_quadChartDTO_sciEngImpactDTO_sciEngImpactText
qc_upload_input								xpath							//input[@id='quadImageUpload']
qc_image_caption							id								quadChartForm_quadChartDTO_graphicsDTO_imageCaption
save_quad_chart 							xpath							//button[@class='button-icon save-button']
submit_quad_chart							xpath							//button[@class='button-icon submit-button']
								
allo_summ_save_button						id								saveButtonSorRequest
tabs										xpath							//span[@class='k-link']
storage_resource1							id  							sorAppInfoForm_sorAppInfoDTO_memoryReqY
storage_resource2							id  							sorAppInfoForm_sorAppInfoDTO_nccsDataPortalY
select_compiler								xpath							//div[@class='k-content k-state-active']//div[@class='k-multiselect-wrap k-floatwrap']
select_complier     						xpath							//div[@class='k-animation-container']//ul[@id='compilerType_listbox']//li[@data-offset-index='3']

allication_info_save_button					xpath							//div[@class='k-content k-state-active']//button[@class='button-icon save-button']

identity_data_security						id							    sorDataSecurityForm_sorDataSecurityDTO_scientificEngRsrchInfoY
senstitive_data								id								nonSensitiveY
recovery_level 								xpath							//li[@class='divider-element']//span[@class='k-input']
select_recovery_level						xpath							//div[@class='k-animation-container']//ul[@id='recoveryLevel_listbox']//li[@data-offset-index='4']
save_data_security							id								saveButtonSorDataSecurity

nas_temp_storage							id								nasTemporaryStorage
nas_during_award							id							    nasDuringAward
nccs_temp_storage							id								nccsTemporaryStorage
nccs_previous_award							id								nccsPreviousAward
save_storage_data							id								saveButtonSorDataStorage

save_sor									xpath							//button[@class='button-icon save-button submitButtonSorReview']
return_project								xpath							//button[@class='button-icon back-button return-button']
projected_end_date							id								projectedEndDate
notification							    xpath						 //span[contains(@class,'success-notification')]/parent::div//span[contains(@class,'notification-message')]

cr_request_title							xpath							//div[contains(@class, 'selectedStage')]//div[contains(text(), 'Computing Request')]/following-sibling::div[contains(text(), 'Incomplete')]/ancestor::div[@class='list-container']//div[@class='banner-title']/div
																			
																			
find_request_entry							xpath							
cr_cover_sheet								xpath							//div[contains(text(), '{requestnumber}')]/ancestor::div[@class='list-container']//span[@title='Update Cover Sheet']//span[@class='action-link-text']
cr_summary_of_req							xpath							//div[contains(text(), '{requestnumber}')]/ancestor::div[@class='list-container']//span[@title='Update Summary Of Requirements']//span[@class='action-link-text']
cr_quad_chart								xpath							//div[contains(text(), '{requestnumber}')]/ancestor::div[@class='list-container']//span[@title='Update Quad Chart']//span[@class='action-link-text']
cr_final_submission						    xpath                           //div[contains(text(), '{requestnumber}')]/ancestor::div[@class='list-container']//span[@title='Update Final Submission']//span[@class='action-link-text']
loading_image								xpath							//div[@class='k-loading-image']

downlaod									xpath							//span[@class='action-link-icon download-icon']	
new_name									id 								div_id					
								
==================================================================================================================