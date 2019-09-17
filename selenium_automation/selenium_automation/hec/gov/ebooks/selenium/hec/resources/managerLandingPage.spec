Page Title: HECLoginPage

# Object Definitions
==================================================================================================================
admin_tools_widget						xpath							//div[@title='Admin Tools']
ealerts_widget							xpath							//div[@title='eAlert']

review_icon								xpath							//span[@class='action-link-icon review-icon']

comment_area							xpath							//iframe[@class='k-content']
send_email								id								allocationRequestForm_phase1RequestDTO_sendEmail
submit_button							xpath							//button[@class='button-icon submit-button submit-review-form']

user_name								xpath							//div[@class='name nav']
logout									id								dashboardLogoutButton
project_banner							xpath							//div[@class='banner-title']//div

nas_pleiades_sbus						id								phase2ReviewForm_phase2AllocationDetailsDTO_0__machines_0__sbu
nas_endeavour_sbus						id								phase2ReviewForm_phase2AllocationDetailsDTO_0__machines_1__sbu
nccs_discover_sbus						id								phase2ReviewForm_phase2AllocationDetailsDTO_0__machines_2__sbu
nas_pleiades_storage					id								storageValueReq
gid										id								gid
approval_status							id								approvalStatus
approval_status_approved				id								//select[@id='approvalStatus']//option[@value='APPROVED']
approval_status_not_approved			id								//select[@id='approvalStatus']//option[@value='NOT_APPROVED']
send_email_cr							id								phase2ReviewForm_phase2RequestDTO_sendEmail
submit_cr_review						id								submitButtonPhase2Review
non_roses_ealert_line					xpath							//tr[td[contains(text(),'{projectNumber}')]]//span[@class='action-link-icon review-icon']
view_page_close							xpath						   //span[@class='k-icon k-i-close']
notification							xpath							 //span[contains(@class,'success-notification')]/parent::div//span[contains(@class,'notification-message')]
loading_image							xpath							//div[@class='k-loading-image']



==================================================================================================================