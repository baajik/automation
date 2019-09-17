Page Title: leadReviewer

# Object Definitions
==================================================================================================================
admin_tools    						  	 id								admin-tools-dropdown

toggle_button							 xpath							//span[@title='Toggle View']
update_evaluation                 		 xpath            			    //proposal-action[@type='update_evaluation']
view_evaluation                 		 xpath            			    //proposal-action[@type='view_evaluation']
my_discussion_notes                 	 xpath            			    //proposal-action[@type='panel_discussion_notes']
send_scribe_message						 xpath							//proposal-action[@type='send_scribe_message']
scribe_notes_link		                 xpath            			    //proposal-action[@type='update_scribe_notes']
scribe_notes							 id								scribeNotes
scribe_notes_textarea					 xpath							//textarea[@ng-if='updateScribeNotes']
scribe_messages							 id								scribeMessages
proposal_summary 						 id								proposalSummary
factor2									 id								factor2
internal_comments						 id							    internalComments
check_box_lead_reviewer	  				 xpath							//input[@type='checkbox']

save_notes								 xpath							//button[@ng-disabled='requestSent']
scoring_window							 xpath							//div[@class='factor-score ng-binding']
scoring_input							 xpath							//div[contains(@class, 'factor-score')]//input
scoring_input_shell						 xpath							//div[contains(@class, 'factor-score')]
save									 xpath							//button[@ng-disabled='requestSent']
scibe_notes_view_mode					 xpath							//div[@class='tab-content view-mode']
close									 xpath							//span[@class='icon-small close-small-icon ng-scope']
check_version							 xpath							//select[@ng-model='proposal.selectedVersion']
latest_version							 xpath							//option[@selected='selected']
notification1							 xpath							//div[@class='notification-message']//span
user_name								 id								my-account-dropdown
logout									 xpath							//a[@href='/review/logoutSystemUser']
discard_button							 xpath							//button[@ng-click='discard()']				
active_stage							 xpath							//div[contains(@class, "active")]
window_header							 xpath							//div[@class='header']
message_text_area						 xpath							//textarea[@ng-model='message']
submit_message							 xpath							//input[@type='submit']
button									 xpath							//button[@ng-click='windowToggle()']
append_scribe_notes						 xpath							//span[@title='Append to Scribe Notes']

success_message 						 xpath							//div//h4[@class='ng-binding']
==================================================================================================================