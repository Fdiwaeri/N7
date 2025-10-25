package fr.n7.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.n7.services.PDL1GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPDL1Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'process'", "'{'", "'}'", "'wd'", "'uses'", "','", "'ws'", "'from'", "'to'", "'note'", "'r'", "'usage'", "'s2s'", "'f2s'", "'s2f'", "'f2f'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalPDL1Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPDL1Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPDL1Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalPDL1.g"; }



     	private PDL1GrammarAccess grammarAccess;

        public InternalPDL1Parser(TokenStream input, PDL1GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Process";
       	}

       	@Override
       	protected PDL1GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProcess"
    // InternalPDL1.g:65:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalPDL1.g:65:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalPDL1.g:66:2: iv_ruleProcess= ruleProcess EOF
            {
             newCompositeNode(grammarAccess.getProcessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcess=ruleProcess();

            state._fsp--;

             current =iv_ruleProcess; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalPDL1.g:72:1: ruleProcess returns [EObject current=null] : (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_processElements_3_0= ruleProcessElement ) )* ( (lv_resources_4_0= ruleResource ) )* otherlv_5= '}' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_processElements_3_0 = null;

        EObject lv_resources_4_0 = null;



        	enterRule();

        try {
            // InternalPDL1.g:78:2: ( (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_processElements_3_0= ruleProcessElement ) )* ( (lv_resources_4_0= ruleResource ) )* otherlv_5= '}' ) )
            // InternalPDL1.g:79:2: (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_processElements_3_0= ruleProcessElement ) )* ( (lv_resources_4_0= ruleResource ) )* otherlv_5= '}' )
            {
            // InternalPDL1.g:79:2: (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_processElements_3_0= ruleProcessElement ) )* ( (lv_resources_4_0= ruleResource ) )* otherlv_5= '}' )
            // InternalPDL1.g:80:3: otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_processElements_3_0= ruleProcessElement ) )* ( (lv_resources_4_0= ruleResource ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getProcessKeyword_0());
            		
            // InternalPDL1.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPDL1.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPDL1.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalPDL1.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProcessRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalPDL1.g:106:3: ( (lv_processElements_3_0= ruleProcessElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14||LA1_0==17||LA1_0==20) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPDL1.g:107:4: (lv_processElements_3_0= ruleProcessElement )
            	    {
            	    // InternalPDL1.g:107:4: (lv_processElements_3_0= ruleProcessElement )
            	    // InternalPDL1.g:108:5: lv_processElements_3_0= ruleProcessElement
            	    {

            	    					newCompositeNode(grammarAccess.getProcessAccess().getProcessElementsProcessElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_processElements_3_0=ruleProcessElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProcessRule());
            	    					}
            	    					add(
            	    						current,
            	    						"processElements",
            	    						lv_processElements_3_0,
            	    						"fr.n7.PDL1.ProcessElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalPDL1.g:125:3: ( (lv_resources_4_0= ruleResource ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==21) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalPDL1.g:126:4: (lv_resources_4_0= ruleResource )
            	    {
            	    // InternalPDL1.g:126:4: (lv_resources_4_0= ruleResource )
            	    // InternalPDL1.g:127:5: lv_resources_4_0= ruleResource
            	    {

            	    					newCompositeNode(grammarAccess.getProcessAccess().getResourcesResourceParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_resources_4_0=ruleResource();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProcessRule());
            	    					}
            	    					add(
            	    						current,
            	    						"resources",
            	    						lv_resources_4_0,
            	    						"fr.n7.PDL1.Resource");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleProcessElement"
    // InternalPDL1.g:152:1: entryRuleProcessElement returns [EObject current=null] : iv_ruleProcessElement= ruleProcessElement EOF ;
    public final EObject entryRuleProcessElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessElement = null;


        try {
            // InternalPDL1.g:152:55: (iv_ruleProcessElement= ruleProcessElement EOF )
            // InternalPDL1.g:153:2: iv_ruleProcessElement= ruleProcessElement EOF
            {
             newCompositeNode(grammarAccess.getProcessElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcessElement=ruleProcessElement();

            state._fsp--;

             current =iv_ruleProcessElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessElement"


    // $ANTLR start "ruleProcessElement"
    // InternalPDL1.g:159:1: ruleProcessElement returns [EObject current=null] : (this_WorkDefinition_0= ruleWorkDefinition | this_WorkSequence_1= ruleWorkSequence | this_Guidance_2= ruleGuidance ) ;
    public final EObject ruleProcessElement() throws RecognitionException {
        EObject current = null;

        EObject this_WorkDefinition_0 = null;

        EObject this_WorkSequence_1 = null;

        EObject this_Guidance_2 = null;



        	enterRule();

        try {
            // InternalPDL1.g:165:2: ( (this_WorkDefinition_0= ruleWorkDefinition | this_WorkSequence_1= ruleWorkSequence | this_Guidance_2= ruleGuidance ) )
            // InternalPDL1.g:166:2: (this_WorkDefinition_0= ruleWorkDefinition | this_WorkSequence_1= ruleWorkSequence | this_Guidance_2= ruleGuidance )
            {
            // InternalPDL1.g:166:2: (this_WorkDefinition_0= ruleWorkDefinition | this_WorkSequence_1= ruleWorkSequence | this_Guidance_2= ruleGuidance )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt3=1;
                }
                break;
            case 17:
                {
                alt3=2;
                }
                break;
            case 20:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalPDL1.g:167:3: this_WorkDefinition_0= ruleWorkDefinition
                    {

                    			newCompositeNode(grammarAccess.getProcessElementAccess().getWorkDefinitionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_WorkDefinition_0=ruleWorkDefinition();

                    state._fsp--;


                    			current = this_WorkDefinition_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPDL1.g:176:3: this_WorkSequence_1= ruleWorkSequence
                    {

                    			newCompositeNode(grammarAccess.getProcessElementAccess().getWorkSequenceParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_WorkSequence_1=ruleWorkSequence();

                    state._fsp--;


                    			current = this_WorkSequence_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalPDL1.g:185:3: this_Guidance_2= ruleGuidance
                    {

                    			newCompositeNode(grammarAccess.getProcessElementAccess().getGuidanceParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Guidance_2=ruleGuidance();

                    state._fsp--;


                    			current = this_Guidance_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessElement"


    // $ANTLR start "entryRuleWorkDefinition"
    // InternalPDL1.g:197:1: entryRuleWorkDefinition returns [EObject current=null] : iv_ruleWorkDefinition= ruleWorkDefinition EOF ;
    public final EObject entryRuleWorkDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkDefinition = null;


        try {
            // InternalPDL1.g:197:55: (iv_ruleWorkDefinition= ruleWorkDefinition EOF )
            // InternalPDL1.g:198:2: iv_ruleWorkDefinition= ruleWorkDefinition EOF
            {
             newCompositeNode(grammarAccess.getWorkDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkDefinition=ruleWorkDefinition();

            state._fsp--;

             current =iv_ruleWorkDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorkDefinition"


    // $ANTLR start "ruleWorkDefinition"
    // InternalPDL1.g:204:1: ruleWorkDefinition returns [EObject current=null] : (otherlv_0= 'wd' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'uses' ( (lv_usageresources_3_0= ruleUsageResource ) ) (otherlv_4= ',' ( (lv_useages_5_0= ruleUsageResource ) ) )* )? ) ;
    public final EObject ruleWorkDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_usageresources_3_0 = null;

        EObject lv_useages_5_0 = null;



        	enterRule();

        try {
            // InternalPDL1.g:210:2: ( (otherlv_0= 'wd' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'uses' ( (lv_usageresources_3_0= ruleUsageResource ) ) (otherlv_4= ',' ( (lv_useages_5_0= ruleUsageResource ) ) )* )? ) )
            // InternalPDL1.g:211:2: (otherlv_0= 'wd' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'uses' ( (lv_usageresources_3_0= ruleUsageResource ) ) (otherlv_4= ',' ( (lv_useages_5_0= ruleUsageResource ) ) )* )? )
            {
            // InternalPDL1.g:211:2: (otherlv_0= 'wd' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'uses' ( (lv_usageresources_3_0= ruleUsageResource ) ) (otherlv_4= ',' ( (lv_useages_5_0= ruleUsageResource ) ) )* )? )
            // InternalPDL1.g:212:3: otherlv_0= 'wd' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'uses' ( (lv_usageresources_3_0= ruleUsageResource ) ) (otherlv_4= ',' ( (lv_useages_5_0= ruleUsageResource ) ) )* )?
            {
            otherlv_0=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getWorkDefinitionAccess().getWdKeyword_0());
            		
            // InternalPDL1.g:216:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPDL1.g:217:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPDL1.g:217:4: (lv_name_1_0= RULE_ID )
            // InternalPDL1.g:218:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getWorkDefinitionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWorkDefinitionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalPDL1.g:234:3: (otherlv_2= 'uses' ( (lv_usageresources_3_0= ruleUsageResource ) ) (otherlv_4= ',' ( (lv_useages_5_0= ruleUsageResource ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalPDL1.g:235:4: otherlv_2= 'uses' ( (lv_usageresources_3_0= ruleUsageResource ) ) (otherlv_4= ',' ( (lv_useages_5_0= ruleUsageResource ) ) )*
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_2, grammarAccess.getWorkDefinitionAccess().getUsesKeyword_2_0());
                    			
                    // InternalPDL1.g:239:4: ( (lv_usageresources_3_0= ruleUsageResource ) )
                    // InternalPDL1.g:240:5: (lv_usageresources_3_0= ruleUsageResource )
                    {
                    // InternalPDL1.g:240:5: (lv_usageresources_3_0= ruleUsageResource )
                    // InternalPDL1.g:241:6: lv_usageresources_3_0= ruleUsageResource
                    {

                    						newCompositeNode(grammarAccess.getWorkDefinitionAccess().getUsageresourcesUsageResourceParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_usageresources_3_0=ruleUsageResource();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWorkDefinitionRule());
                    						}
                    						add(
                    							current,
                    							"usageresources",
                    							lv_usageresources_3_0,
                    							"fr.n7.PDL1.UsageResource");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalPDL1.g:258:4: (otherlv_4= ',' ( (lv_useages_5_0= ruleUsageResource ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalPDL1.g:259:5: otherlv_4= ',' ( (lv_useages_5_0= ruleUsageResource ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_8); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getWorkDefinitionAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalPDL1.g:263:5: ( (lv_useages_5_0= ruleUsageResource ) )
                    	    // InternalPDL1.g:264:6: (lv_useages_5_0= ruleUsageResource )
                    	    {
                    	    // InternalPDL1.g:264:6: (lv_useages_5_0= ruleUsageResource )
                    	    // InternalPDL1.g:265:7: lv_useages_5_0= ruleUsageResource
                    	    {

                    	    							newCompositeNode(grammarAccess.getWorkDefinitionAccess().getUseagesUsageResourceParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_useages_5_0=ruleUsageResource();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWorkDefinitionRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"useages",
                    	    								lv_useages_5_0,
                    	    								"fr.n7.PDL1.UsageResource");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkDefinition"


    // $ANTLR start "entryRuleWorkSequence"
    // InternalPDL1.g:288:1: entryRuleWorkSequence returns [EObject current=null] : iv_ruleWorkSequence= ruleWorkSequence EOF ;
    public final EObject entryRuleWorkSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkSequence = null;


        try {
            // InternalPDL1.g:288:53: (iv_ruleWorkSequence= ruleWorkSequence EOF )
            // InternalPDL1.g:289:2: iv_ruleWorkSequence= ruleWorkSequence EOF
            {
             newCompositeNode(grammarAccess.getWorkSequenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkSequence=ruleWorkSequence();

            state._fsp--;

             current =iv_ruleWorkSequence; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorkSequence"


    // $ANTLR start "ruleWorkSequence"
    // InternalPDL1.g:295:1: ruleWorkSequence returns [EObject current=null] : (otherlv_0= 'ws' ( (lv_linkType_1_0= ruleWorkSequenceType ) ) otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) ) ;
    public final EObject ruleWorkSequence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Enumerator lv_linkType_1_0 = null;



        	enterRule();

        try {
            // InternalPDL1.g:301:2: ( (otherlv_0= 'ws' ( (lv_linkType_1_0= ruleWorkSequenceType ) ) otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) ) )
            // InternalPDL1.g:302:2: (otherlv_0= 'ws' ( (lv_linkType_1_0= ruleWorkSequenceType ) ) otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) )
            {
            // InternalPDL1.g:302:2: (otherlv_0= 'ws' ( (lv_linkType_1_0= ruleWorkSequenceType ) ) otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) )
            // InternalPDL1.g:303:3: otherlv_0= 'ws' ( (lv_linkType_1_0= ruleWorkSequenceType ) ) otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getWorkSequenceAccess().getWsKeyword_0());
            		
            // InternalPDL1.g:307:3: ( (lv_linkType_1_0= ruleWorkSequenceType ) )
            // InternalPDL1.g:308:4: (lv_linkType_1_0= ruleWorkSequenceType )
            {
            // InternalPDL1.g:308:4: (lv_linkType_1_0= ruleWorkSequenceType )
            // InternalPDL1.g:309:5: lv_linkType_1_0= ruleWorkSequenceType
            {

            					newCompositeNode(grammarAccess.getWorkSequenceAccess().getLinkTypeWorkSequenceTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_11);
            lv_linkType_1_0=ruleWorkSequenceType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWorkSequenceRule());
            					}
            					set(
            						current,
            						"linkType",
            						lv_linkType_1_0,
            						"fr.n7.PDL1.WorkSequenceType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getWorkSequenceAccess().getFromKeyword_2());
            		
            // InternalPDL1.g:330:3: ( (otherlv_3= RULE_ID ) )
            // InternalPDL1.g:331:4: (otherlv_3= RULE_ID )
            {
            // InternalPDL1.g:331:4: (otherlv_3= RULE_ID )
            // InternalPDL1.g:332:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWorkSequenceRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_3, grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getWorkSequenceAccess().getToKeyword_4());
            		
            // InternalPDL1.g:347:3: ( (otherlv_5= RULE_ID ) )
            // InternalPDL1.g:348:4: (otherlv_5= RULE_ID )
            {
            // InternalPDL1.g:348:4: (otherlv_5= RULE_ID )
            // InternalPDL1.g:349:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWorkSequenceRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_5, grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionCrossReference_5_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkSequence"


    // $ANTLR start "entryRuleGuidance"
    // InternalPDL1.g:364:1: entryRuleGuidance returns [EObject current=null] : iv_ruleGuidance= ruleGuidance EOF ;
    public final EObject entryRuleGuidance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuidance = null;


        try {
            // InternalPDL1.g:364:49: (iv_ruleGuidance= ruleGuidance EOF )
            // InternalPDL1.g:365:2: iv_ruleGuidance= ruleGuidance EOF
            {
             newCompositeNode(grammarAccess.getGuidanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGuidance=ruleGuidance();

            state._fsp--;

             current =iv_ruleGuidance; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuidance"


    // $ANTLR start "ruleGuidance"
    // InternalPDL1.g:371:1: ruleGuidance returns [EObject current=null] : (otherlv_0= 'note' ( (lv_texte_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleGuidance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_texte_1_0=null;


        	enterRule();

        try {
            // InternalPDL1.g:377:2: ( (otherlv_0= 'note' ( (lv_texte_1_0= RULE_STRING ) ) ) )
            // InternalPDL1.g:378:2: (otherlv_0= 'note' ( (lv_texte_1_0= RULE_STRING ) ) )
            {
            // InternalPDL1.g:378:2: (otherlv_0= 'note' ( (lv_texte_1_0= RULE_STRING ) ) )
            // InternalPDL1.g:379:3: otherlv_0= 'note' ( (lv_texte_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getGuidanceAccess().getNoteKeyword_0());
            		
            // InternalPDL1.g:383:3: ( (lv_texte_1_0= RULE_STRING ) )
            // InternalPDL1.g:384:4: (lv_texte_1_0= RULE_STRING )
            {
            // InternalPDL1.g:384:4: (lv_texte_1_0= RULE_STRING )
            // InternalPDL1.g:385:5: lv_texte_1_0= RULE_STRING
            {
            lv_texte_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_texte_1_0, grammarAccess.getGuidanceAccess().getTexteSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGuidanceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"texte",
            						lv_texte_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuidance"


    // $ANTLR start "entryRuleResource"
    // InternalPDL1.g:405:1: entryRuleResource returns [EObject current=null] : iv_ruleResource= ruleResource EOF ;
    public final EObject entryRuleResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResource = null;


        try {
            // InternalPDL1.g:405:49: (iv_ruleResource= ruleResource EOF )
            // InternalPDL1.g:406:2: iv_ruleResource= ruleResource EOF
            {
             newCompositeNode(grammarAccess.getResourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResource=ruleResource();

            state._fsp--;

             current =iv_ruleResource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResource"


    // $ANTLR start "ruleResource"
    // InternalPDL1.g:412:1: ruleResource returns [EObject current=null] : (otherlv_0= 'r' ( (lv_name_1_0= RULE_ID ) ) ( (lv_quantity_2_0= RULE_INT ) ) ( (lv_description_3_0= RULE_STRING ) )? ) ;
    public final EObject ruleResource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_quantity_2_0=null;
        Token lv_description_3_0=null;


        	enterRule();

        try {
            // InternalPDL1.g:418:2: ( (otherlv_0= 'r' ( (lv_name_1_0= RULE_ID ) ) ( (lv_quantity_2_0= RULE_INT ) ) ( (lv_description_3_0= RULE_STRING ) )? ) )
            // InternalPDL1.g:419:2: (otherlv_0= 'r' ( (lv_name_1_0= RULE_ID ) ) ( (lv_quantity_2_0= RULE_INT ) ) ( (lv_description_3_0= RULE_STRING ) )? )
            {
            // InternalPDL1.g:419:2: (otherlv_0= 'r' ( (lv_name_1_0= RULE_ID ) ) ( (lv_quantity_2_0= RULE_INT ) ) ( (lv_description_3_0= RULE_STRING ) )? )
            // InternalPDL1.g:420:3: otherlv_0= 'r' ( (lv_name_1_0= RULE_ID ) ) ( (lv_quantity_2_0= RULE_INT ) ) ( (lv_description_3_0= RULE_STRING ) )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getResourceAccess().getRKeyword_0());
            		
            // InternalPDL1.g:424:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPDL1.g:425:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPDL1.g:425:4: (lv_name_1_0= RULE_ID )
            // InternalPDL1.g:426:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getResourceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getResourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalPDL1.g:442:3: ( (lv_quantity_2_0= RULE_INT ) )
            // InternalPDL1.g:443:4: (lv_quantity_2_0= RULE_INT )
            {
            // InternalPDL1.g:443:4: (lv_quantity_2_0= RULE_INT )
            // InternalPDL1.g:444:5: lv_quantity_2_0= RULE_INT
            {
            lv_quantity_2_0=(Token)match(input,RULE_INT,FOLLOW_15); 

            					newLeafNode(lv_quantity_2_0, grammarAccess.getResourceAccess().getQuantityINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getResourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"quantity",
            						lv_quantity_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalPDL1.g:460:3: ( (lv_description_3_0= RULE_STRING ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalPDL1.g:461:4: (lv_description_3_0= RULE_STRING )
                    {
                    // InternalPDL1.g:461:4: (lv_description_3_0= RULE_STRING )
                    // InternalPDL1.g:462:5: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_description_3_0, grammarAccess.getResourceAccess().getDescriptionSTRINGTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getResourceRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"description",
                    						lv_description_3_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResource"


    // $ANTLR start "entryRuleUsageResource"
    // InternalPDL1.g:482:1: entryRuleUsageResource returns [EObject current=null] : iv_ruleUsageResource= ruleUsageResource EOF ;
    public final EObject entryRuleUsageResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUsageResource = null;


        try {
            // InternalPDL1.g:482:54: (iv_ruleUsageResource= ruleUsageResource EOF )
            // InternalPDL1.g:483:2: iv_ruleUsageResource= ruleUsageResource EOF
            {
             newCompositeNode(grammarAccess.getUsageResourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUsageResource=ruleUsageResource();

            state._fsp--;

             current =iv_ruleUsageResource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUsageResource"


    // $ANTLR start "ruleUsageResource"
    // InternalPDL1.g:489:1: ruleUsageResource returns [EObject current=null] : (otherlv_0= 'usage' ( (otherlv_1= RULE_ID ) ) ( (lv_UsageQuantity_2_0= RULE_INT ) ) ( (lv_UsageTime_3_0= RULE_INT ) )? ) ;
    public final EObject ruleUsageResource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_UsageQuantity_2_0=null;
        Token lv_UsageTime_3_0=null;


        	enterRule();

        try {
            // InternalPDL1.g:495:2: ( (otherlv_0= 'usage' ( (otherlv_1= RULE_ID ) ) ( (lv_UsageQuantity_2_0= RULE_INT ) ) ( (lv_UsageTime_3_0= RULE_INT ) )? ) )
            // InternalPDL1.g:496:2: (otherlv_0= 'usage' ( (otherlv_1= RULE_ID ) ) ( (lv_UsageQuantity_2_0= RULE_INT ) ) ( (lv_UsageTime_3_0= RULE_INT ) )? )
            {
            // InternalPDL1.g:496:2: (otherlv_0= 'usage' ( (otherlv_1= RULE_ID ) ) ( (lv_UsageQuantity_2_0= RULE_INT ) ) ( (lv_UsageTime_3_0= RULE_INT ) )? )
            // InternalPDL1.g:497:3: otherlv_0= 'usage' ( (otherlv_1= RULE_ID ) ) ( (lv_UsageQuantity_2_0= RULE_INT ) ) ( (lv_UsageTime_3_0= RULE_INT ) )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getUsageResourceAccess().getUsageKeyword_0());
            		
            // InternalPDL1.g:501:3: ( (otherlv_1= RULE_ID ) )
            // InternalPDL1.g:502:4: (otherlv_1= RULE_ID )
            {
            // InternalPDL1.g:502:4: (otherlv_1= RULE_ID )
            // InternalPDL1.g:503:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUsageResourceRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(otherlv_1, grammarAccess.getUsageResourceAccess().getResourceResourceCrossReference_1_0());
            				

            }


            }

            // InternalPDL1.g:514:3: ( (lv_UsageQuantity_2_0= RULE_INT ) )
            // InternalPDL1.g:515:4: (lv_UsageQuantity_2_0= RULE_INT )
            {
            // InternalPDL1.g:515:4: (lv_UsageQuantity_2_0= RULE_INT )
            // InternalPDL1.g:516:5: lv_UsageQuantity_2_0= RULE_INT
            {
            lv_UsageQuantity_2_0=(Token)match(input,RULE_INT,FOLLOW_16); 

            					newLeafNode(lv_UsageQuantity_2_0, grammarAccess.getUsageResourceAccess().getUsageQuantityINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUsageResourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"UsageQuantity",
            						lv_UsageQuantity_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalPDL1.g:532:3: ( (lv_UsageTime_3_0= RULE_INT ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_INT) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalPDL1.g:533:4: (lv_UsageTime_3_0= RULE_INT )
                    {
                    // InternalPDL1.g:533:4: (lv_UsageTime_3_0= RULE_INT )
                    // InternalPDL1.g:534:5: lv_UsageTime_3_0= RULE_INT
                    {
                    lv_UsageTime_3_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    					newLeafNode(lv_UsageTime_3_0, grammarAccess.getUsageResourceAccess().getUsageTimeINTTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUsageResourceRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"UsageTime",
                    						lv_UsageTime_3_0,
                    						"org.eclipse.xtext.common.Terminals.INT");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUsageResource"


    // $ANTLR start "ruleWorkSequenceType"
    // InternalPDL1.g:554:1: ruleWorkSequenceType returns [Enumerator current=null] : ( (enumLiteral_0= 's2s' ) | (enumLiteral_1= 'f2s' ) | (enumLiteral_2= 's2f' ) | (enumLiteral_3= 'f2f' ) ) ;
    public final Enumerator ruleWorkSequenceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalPDL1.g:560:2: ( ( (enumLiteral_0= 's2s' ) | (enumLiteral_1= 'f2s' ) | (enumLiteral_2= 's2f' ) | (enumLiteral_3= 'f2f' ) ) )
            // InternalPDL1.g:561:2: ( (enumLiteral_0= 's2s' ) | (enumLiteral_1= 'f2s' ) | (enumLiteral_2= 's2f' ) | (enumLiteral_3= 'f2f' ) )
            {
            // InternalPDL1.g:561:2: ( (enumLiteral_0= 's2s' ) | (enumLiteral_1= 'f2s' ) | (enumLiteral_2= 's2f' ) | (enumLiteral_3= 'f2f' ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt8=1;
                }
                break;
            case 24:
                {
                alt8=2;
                }
                break;
            case 25:
                {
                alt8=3;
                }
                break;
            case 26:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalPDL1.g:562:3: (enumLiteral_0= 's2s' )
                    {
                    // InternalPDL1.g:562:3: (enumLiteral_0= 's2s' )
                    // InternalPDL1.g:563:4: enumLiteral_0= 's2s'
                    {
                    enumLiteral_0=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getWorkSequenceTypeAccess().getStart2startEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getWorkSequenceTypeAccess().getStart2startEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPDL1.g:570:3: (enumLiteral_1= 'f2s' )
                    {
                    // InternalPDL1.g:570:3: (enumLiteral_1= 'f2s' )
                    // InternalPDL1.g:571:4: enumLiteral_1= 'f2s'
                    {
                    enumLiteral_1=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getWorkSequenceTypeAccess().getFinish2startEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getWorkSequenceTypeAccess().getFinish2startEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalPDL1.g:578:3: (enumLiteral_2= 's2f' )
                    {
                    // InternalPDL1.g:578:3: (enumLiteral_2= 's2f' )
                    // InternalPDL1.g:579:4: enumLiteral_2= 's2f'
                    {
                    enumLiteral_2=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getWorkSequenceTypeAccess().getStart2finishEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getWorkSequenceTypeAccess().getStart2finishEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalPDL1.g:586:3: (enumLiteral_3= 'f2f' )
                    {
                    // InternalPDL1.g:586:3: (enumLiteral_3= 'f2f' )
                    // InternalPDL1.g:587:4: enumLiteral_3= 'f2f'
                    {
                    enumLiteral_3=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getWorkSequenceTypeAccess().getFinish2finishEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getWorkSequenceTypeAccess().getFinish2finishEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkSequenceType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000326000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000007800000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000042L});

}