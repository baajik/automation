Page Title: leadReviewer

# Object Definitions
==================================================================================================================
admin_tools    						  	 id								admin-tools-dropdown

toggle_button							 xpath							//span[@title='Toggle View']
update_evaluation                 		 xpath            			    //proposal-action[@type='update_evaluation']
view_evaluation                 		 xpath            			    //proposal-action[@type='view_evaluation']
my_discussion_notes                 	 xpath            			    //proposal-action[@type='panel_discussion_notes']
discussion_notes						 xpath					        //textarea[@placeholder='Enter Notes...']
save_notes								xpath							//button[@ng-disabled='requestSent']

save									 xpath							//button[@ng-disabled='requestSent']
scibe_notes_view_mode					 xpath							//div[@class='tab-content view-mode']

qc_comments_link						 xpath							//proposal-action[@type='update_QC_comments']
qc_comments_textarea					 xpath							

notification						     xpath						 	//span[contains(@class,'success-notification')]/parent::div//span[contains(@class,'notification-message')]
user_name								 id								my-account-dropdown
logout									 xpath							//a[@href='/review/logoutSystemUser']

==================================================================================================================