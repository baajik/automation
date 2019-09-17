Page Title: scoring_SuperUser_StartScoringEvent

# Object Definitions
==================================================================================================================
admin_tools    						  	 id								admin-tools-dropdown

toggle_button							 xpath							//span[@title='Toggle View']
panel_scoring_overview					 xpath							//proposal-action[@type='panel_scoring']
scribe_notes							 xpath							//proposal-action[@type='update_scribe_notes']
update_evaluation                 		 xpath            			    //proposal-action[@type='update_evaluation']
view_evaluation                 		 xpath            			    //proposal-action[@type='view_evaluation']
my_discussion_notes                 	 xpath            			    //proposal-action[@type='panel_discussion_notes']
discussion_notes						 xpath					        //textarea[@placeholder='Enter Notes...']
save_notes								xpath							//button[@ng-disabled='requestSent']
scoring_window							 xpath							//div[@class='factor-score ng-binding']
scoring_input							 xpath							//div[contains(@class, 'factor-score')]//input
comments								 xpath							//textarea[@name='comments']
internal_comments						 xpath							//textarea[@name='internalComments']
save									 xpath							//button[@ng-disabled='requestSent']
scibe_notes_view_mode					 xpath							//div[@class='tab-content view-mode']
check_box								 xpath							//input[@type='checkbox']
close									 xpath							//span[@class='icon-small close-small-icon ng-scope']
check_version							 xpath							//select[@ng-model='proposal.selectedVersion']

qc_comments_link						 xpath							//proposal-action[@type='update_QC_comments']
qc_comments_textarea					 xpath							
start_scoring_button					 xpath							//button[@ng-click='startPanelScoring()']
stop_scoring_button						 xpath							//button[@ng-click='endPanelScoring()']
notification						     xpath						 	//span[contains(@class,'success-notification')]/parent::div//span[contains(@class,'notification-message')]
search_field							 xpath							//div[@id='search-field-wrapper']//input[@type='text']

panel_score							 	 xpath							//div[@class='score-overview-category']
average_score							 xpath							//div[contains(@class, 'window-content')]//div[@class='proposal-statistics ng-scope']//span[contains(@class,'ng-binding')]
variance_value							 xpath 							//div[contains(@class, 'window-content')]//div[@class='proposal-statistics ng-scope']//div
==================================================================================================================