Page Title: ManageProposal

# Object Definitions
==================================================================================================================
admin_tools    						 id								admin-tools-dropdown
manage_proposal   					 xpath 							//span[@id='admin-tools-dropdown']//a[@ui-sref='admin.proposal.overview']
search_proposal  					 xpath  						//input[@type='search']
expand_proposal     				 xpath							//a[@class='k-icon k-i-expand'] 
assign_users        				 xpath  						//span[@class='assign-user-small-icon icon-small']
recalculate_mail_in   				 xpath  						//span[@class='recalculate-score-small-icon icon-small']
search_user							 xpath  							//input[@type='search']
select_user     					 xpath  						//td[@class='grid-user-info']
add_select      					 xpath   						//button[@ng-click='addSelected()']
select_role     					 xpath  						//select[@name='userGroup']
select_panel_member					 xpath							//option[@label='Panel Member']
submit          				 	 xpath  						//button[@ng-click='validateSubmit()']
	    		 	
manage_users   						 xpath  			 			//div[@id='admin-navigation']//a[@ui-sref='admin.users.overview'] 
update_profile  					 xpath 							//span[@class='update-profile-small-icon icon-small']
notification						 xpath						 	//span[contains(@class,'success-notification')]/parent::div//span[contains(@class,'notification-message')]
websocket_status					 xpath							//div[@class='connected']

==================================================================================================================