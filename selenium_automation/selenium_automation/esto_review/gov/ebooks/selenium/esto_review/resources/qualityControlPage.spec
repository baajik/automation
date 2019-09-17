Page Title: QualityControl

# Object Definitions
==================================================================================================================
admin_tools    						  	 id								admin-tools-dropdown

toggle_button							 xpath							//span[@title='Toggle View']
update_evaluation                 		 xpath            			    //proposal-action[@type='update_evaluation']
view_evaluation                 		 xpath            			    //proposal-action[@type='view_evaluation']
my_discussion_notes                 	 xpath            			    //proposal-action[@type='panel_discussion_notes']
discussion_notes						 xpath					        //textarea[@placeholder='Enter Notes...']
save_notes								xpath							//button[@ng-disabled='requestSent']
scoring_window							 xpath							//div[@class='factor-score ng-binding']
scoring_input							 xpath							//div[contains(@class, 'factor-score')]//input
scoring_input_shell						xpath							//div[contains(@class, 'factor-score')]
proposal_summary						 xpath							//textarea[@name='summary']
strength								 xpath							//textarea[@name='strengths_0']
weekness								 xpath							//textarea[@name='weaknesses_0']
strength1								 xpath							//textarea[@name='strengths_1']
weekness1								 xpath							//textarea[@name='weaknesses_1']
strength2								 xpath							//textarea[@name='strengths_2']
weekness2								 xpath							//textarea[@name='weaknesses_2']
comments								 xpath							//textarea[@name='comments']
internal_comments						 xpath							//textarea[@name='internalComments']
save									 xpath							//button[@ng-disabled='requestSent']
scibe_notes_view_mode					 xpath							//div[@class='tab-content view-mode']
check_box_panel_official				 xpath							//div[@id='group2']//input[@type='checkbox']
close									 xpath							//span[@class='icon-small close-small-icon ng-scope']
check_version							 xpath							//select[@ng-model='proposal.selectedVersion']
latest_version							 xpath							//option[@selected='selected']
qc_comments_link						 xpath							//proposal-action[@type='update_QC_comments']
qc_comments_textarea					 xpath							//textarea[@name='qcComments']

notification1							 xpath							//div[@class='notification-message']//span
user_name								 id								my-account-dropdown
logout									 xpath							//a[@href='/review/logoutSystemUser']
active_stage							 xpath							//div[contains(@class, "active")]

==================================================================================================================