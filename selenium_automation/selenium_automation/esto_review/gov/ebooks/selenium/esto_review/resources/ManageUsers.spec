Page Title: ManageProposal

# Object Definitions
==================================================================================================================
admin_tools    								id							id admin-tools-dropdown
manage_users   			 					xpath 						//span[@id='admin-tools-dropdown']//a[@ui-sref='admin.users.overview']
manage_users_navigationbar					xpath						//div[@id='admin-navigation']//a[@ui-sref='admin.users.overview']
notify_users_navigationbar					xpath						//div[@id='admin-navigation']//a[@ui-sref='admin.notify']
manage_proposal_stage_navigator				xpath						//div[@id='admin-navigation']//a[@ui-sref='admin.proposalStages']
manage_proposal_navigator					xpath						//div[@id='admin-navigation']//a[@ui-sref='admin.proposal.overview']
add_new_user								xpath						//button[@ng-click='addNewUser()']
first_name									xpath						//input[@name='firstName']
last_name									xpath						//input[@name='lastName']
user_email									xpath						//input[@name='email']
usre_org									xpath						//input[@name='organization']
user_phone									xpath						//input[@name='phone']
potential_user_chk_box						xpath						//input[@ng-model='user.isPotentialParticipant']
submit										xpath						//input[@type='submit']
notification						     	xpath						 //span[contains(@class,'success-notification')]/parent::div//span[contains(@class,'notification-message')]

assign_proposal								xpath						//span[@class='assign-proposal-small-icon icon-small']
select_proposal								xpath						//td[@class='ng-binding']

search_user 								xpath  					//input[@class='ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength']
expand_proposal     						xpath					 	//a[@class='k-icon k-i-expand'] 
assign_users        						xpath  					//span[@class='assign-user-small-icon icon-small']
recalculate_mail_in   						xpath  					//span[@class='recalculate-score-small-icon icon-small']
search_user									xpath  					//input[@class='ng-valid ng-valid-maxlength ng-dirty ng-valid-parse ng-not-empty ng-touched']
select_user     							xpath  					//td[@class='grid-user-info']
add_select      							xpath   					//button[@ng-click='addSelected()']
select_role     							xpath  					//select[@name='userGroup']
select_panel_member							xpath						//option[@label='Panel Member']
assign_proposals_submit						xpath  				 	    //div[@class='align-right ng-scope']//button[@ng-click='validateSubmit()']
	    		 
manage_users   								 xpath  			 		//div[@id='admin-navigation']//a[@ui-sref='admin.users.overview'] 
update_profile  							 xpath 						//span[@class='update-profile-small-icon icon-small']
select_user     							 xpath  					//td[@class='grid-user-info']
select_user_notify							 xpath						//tr[@ng-dblclick='onDoubleClickSelection(dataItem)']
emial_self									 xpath						//button[@ng-click='emailSelf()']
prevew_email								 xpath						//button[@ng-click='previewEmail()']
to_email_field							   	 xpath						//textarea[@ng-model='emailDTO.email.emailTo']
cc_self_checkbox							 xpath						//input[@ng-model='emailDTO.ccSelf']
text_body									 xpath						//iframe
submit_email								xpath						//button[@ng-click='submit()']
==================================================================================================================