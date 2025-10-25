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
import fr.n7.services.PDL3GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPDL3Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'process'", "'workdefinitions'", "';'", "'worksequences'", "'s2s'", "'f2s'", "'s2f'", "'f2f'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalPDL3Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPDL3Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPDL3Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalPDL3.g"; }



     	private PDL3GrammarAccess grammarAccess;

        public InternalPDL3Parser(TokenStream input, PDL3GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected PDL3GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalPDL3.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalPDL3.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalPDL3.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalPDL3.g:72:1: ruleModel returns [EObject current=null] : (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'workdefinitions' ( (lv_workDefinitions_3_0= ruleWorkDefinition ) ) (otherlv_4= ';' ( (lv_workDefinitions_5_0= ruleWorkDefinition ) ) )* otherlv_6= ';' (otherlv_7= 'worksequences' ( (lv_workSequences_8_0= ruleWorkSequence ) ) (otherlv_9= ';' ( (lv_workSequences_10_0= ruleWorkSequence ) ) )* otherlv_11= ';' )? ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_workDefinitions_3_0 = null;

        EObject lv_workDefinitions_5_0 = null;

        EObject lv_workSequences_8_0 = null;

        EObject lv_workSequences_10_0 = null;



        	enterRule();

        try {
            // InternalPDL3.g:78:2: ( (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'workdefinitions' ( (lv_workDefinitions_3_0= ruleWorkDefinition ) ) (otherlv_4= ';' ( (lv_workDefinitions_5_0= ruleWorkDefinition ) ) )* otherlv_6= ';' (otherlv_7= 'worksequences' ( (lv_workSequences_8_0= ruleWorkSequence ) ) (otherlv_9= ';' ( (lv_workSequences_10_0= ruleWorkSequence ) ) )* otherlv_11= ';' )? ) )
            // InternalPDL3.g:79:2: (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'workdefinitions' ( (lv_workDefinitions_3_0= ruleWorkDefinition ) ) (otherlv_4= ';' ( (lv_workDefinitions_5_0= ruleWorkDefinition ) ) )* otherlv_6= ';' (otherlv_7= 'worksequences' ( (lv_workSequences_8_0= ruleWorkSequence ) ) (otherlv_9= ';' ( (lv_workSequences_10_0= ruleWorkSequence ) ) )* otherlv_11= ';' )? )
            {
            // InternalPDL3.g:79:2: (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'workdefinitions' ( (lv_workDefinitions_3_0= ruleWorkDefinition ) ) (otherlv_4= ';' ( (lv_workDefinitions_5_0= ruleWorkDefinition ) ) )* otherlv_6= ';' (otherlv_7= 'worksequences' ( (lv_workSequences_8_0= ruleWorkSequence ) ) (otherlv_9= ';' ( (lv_workSequences_10_0= ruleWorkSequence ) ) )* otherlv_11= ';' )? )
            // InternalPDL3.g:80:3: otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'workdefinitions' ( (lv_workDefinitions_3_0= ruleWorkDefinition ) ) (otherlv_4= ';' ( (lv_workDefinitions_5_0= ruleWorkDefinition ) ) )* otherlv_6= ';' (otherlv_7= 'worksequences' ( (lv_workSequences_8_0= ruleWorkSequence ) ) (otherlv_9= ';' ( (lv_workSequences_10_0= ruleWorkSequence ) ) )* otherlv_11= ';' )?
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getProcessKeyword_0());
            		
            // InternalPDL3.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPDL3.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPDL3.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalPDL3.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getModelAccess().getWorkdefinitionsKeyword_2());
            		
            // InternalPDL3.g:106:3: ( (lv_workDefinitions_3_0= ruleWorkDefinition ) )
            // InternalPDL3.g:107:4: (lv_workDefinitions_3_0= ruleWorkDefinition )
            {
            // InternalPDL3.g:107:4: (lv_workDefinitions_3_0= ruleWorkDefinition )
            // InternalPDL3.g:108:5: lv_workDefinitions_3_0= ruleWorkDefinition
            {

            					newCompositeNode(grammarAccess.getModelAccess().getWorkDefinitionsWorkDefinitionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_5);
            lv_workDefinitions_3_0=ruleWorkDefinition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"workDefinitions",
            						lv_workDefinitions_3_0,
            						"fr.n7.PDL3.WorkDefinition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPDL3.g:125:3: (otherlv_4= ';' ( (lv_workDefinitions_5_0= ruleWorkDefinition ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==RULE_ID) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // InternalPDL3.g:126:4: otherlv_4= ';' ( (lv_workDefinitions_5_0= ruleWorkDefinition ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getModelAccess().getSemicolonKeyword_4_0());
            	    			
            	    // InternalPDL3.g:130:4: ( (lv_workDefinitions_5_0= ruleWorkDefinition ) )
            	    // InternalPDL3.g:131:5: (lv_workDefinitions_5_0= ruleWorkDefinition )
            	    {
            	    // InternalPDL3.g:131:5: (lv_workDefinitions_5_0= ruleWorkDefinition )
            	    // InternalPDL3.g:132:6: lv_workDefinitions_5_0= ruleWorkDefinition
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getWorkDefinitionsWorkDefinitionParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_workDefinitions_5_0=ruleWorkDefinition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"workDefinitions",
            	    							lv_workDefinitions_5_0,
            	    							"fr.n7.PDL3.WorkDefinition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_6, grammarAccess.getModelAccess().getSemicolonKeyword_5());
            		
            // InternalPDL3.g:154:3: (otherlv_7= 'worksequences' ( (lv_workSequences_8_0= ruleWorkSequence ) ) (otherlv_9= ';' ( (lv_workSequences_10_0= ruleWorkSequence ) ) )* otherlv_11= ';' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalPDL3.g:155:4: otherlv_7= 'worksequences' ( (lv_workSequences_8_0= ruleWorkSequence ) ) (otherlv_9= ';' ( (lv_workSequences_10_0= ruleWorkSequence ) ) )* otherlv_11= ';'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getModelAccess().getWorksequencesKeyword_6_0());
                    			
                    // InternalPDL3.g:159:4: ( (lv_workSequences_8_0= ruleWorkSequence ) )
                    // InternalPDL3.g:160:5: (lv_workSequences_8_0= ruleWorkSequence )
                    {
                    // InternalPDL3.g:160:5: (lv_workSequences_8_0= ruleWorkSequence )
                    // InternalPDL3.g:161:6: lv_workSequences_8_0= ruleWorkSequence
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getWorkSequencesWorkSequenceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_workSequences_8_0=ruleWorkSequence();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						add(
                    							current,
                    							"workSequences",
                    							lv_workSequences_8_0,
                    							"fr.n7.PDL3.WorkSequence");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalPDL3.g:178:4: (otherlv_9= ';' ( (lv_workSequences_10_0= ruleWorkSequence ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==13) ) {
                            int LA2_1 = input.LA(2);

                            if ( (LA2_1==RULE_ID) ) {
                                alt2=1;
                            }


                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalPDL3.g:179:5: otherlv_9= ';' ( (lv_workSequences_10_0= ruleWorkSequence ) )
                    	    {
                    	    otherlv_9=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getModelAccess().getSemicolonKeyword_6_2_0());
                    	    				
                    	    // InternalPDL3.g:183:5: ( (lv_workSequences_10_0= ruleWorkSequence ) )
                    	    // InternalPDL3.g:184:6: (lv_workSequences_10_0= ruleWorkSequence )
                    	    {
                    	    // InternalPDL3.g:184:6: (lv_workSequences_10_0= ruleWorkSequence )
                    	    // InternalPDL3.g:185:7: lv_workSequences_10_0= ruleWorkSequence
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getWorkSequencesWorkSequenceParserRuleCall_6_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_5);
                    	    lv_workSequences_10_0=ruleWorkSequence();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"workSequences",
                    	    								lv_workSequences_10_0,
                    	    								"fr.n7.PDL3.WorkSequence");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,13,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getModelAccess().getSemicolonKeyword_6_3());
                    			

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleWorkDefinition"
    // InternalPDL3.g:212:1: entryRuleWorkDefinition returns [EObject current=null] : iv_ruleWorkDefinition= ruleWorkDefinition EOF ;
    public final EObject entryRuleWorkDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkDefinition = null;


        try {
            // InternalPDL3.g:212:55: (iv_ruleWorkDefinition= ruleWorkDefinition EOF )
            // InternalPDL3.g:213:2: iv_ruleWorkDefinition= ruleWorkDefinition EOF
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
    // InternalPDL3.g:219:1: ruleWorkDefinition returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleWorkDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPDL3.g:225:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPDL3.g:226:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPDL3.g:226:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPDL3.g:227:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPDL3.g:227:3: (lv_name_0_0= RULE_ID )
            // InternalPDL3.g:228:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getWorkDefinitionAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getWorkDefinitionRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // InternalPDL3.g:247:1: entryRuleWorkSequence returns [EObject current=null] : iv_ruleWorkSequence= ruleWorkSequence EOF ;
    public final EObject entryRuleWorkSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkSequence = null;


        try {
            // InternalPDL3.g:247:53: (iv_ruleWorkSequence= ruleWorkSequence EOF )
            // InternalPDL3.g:248:2: iv_ruleWorkSequence= ruleWorkSequence EOF
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
    // InternalPDL3.g:254:1: ruleWorkSequence returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_linkType_1_0= ruleWorkSequenceType ) ) ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleWorkSequence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_linkType_1_0 = null;



        	enterRule();

        try {
            // InternalPDL3.g:260:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_linkType_1_0= ruleWorkSequenceType ) ) ( (otherlv_2= RULE_ID ) ) ) )
            // InternalPDL3.g:261:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_linkType_1_0= ruleWorkSequenceType ) ) ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalPDL3.g:261:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_linkType_1_0= ruleWorkSequenceType ) ) ( (otherlv_2= RULE_ID ) ) )
            // InternalPDL3.g:262:3: ( (otherlv_0= RULE_ID ) ) ( (lv_linkType_1_0= ruleWorkSequenceType ) ) ( (otherlv_2= RULE_ID ) )
            {
            // InternalPDL3.g:262:3: ( (otherlv_0= RULE_ID ) )
            // InternalPDL3.g:263:4: (otherlv_0= RULE_ID )
            {
            // InternalPDL3.g:263:4: (otherlv_0= RULE_ID )
            // InternalPDL3.g:264:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWorkSequenceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_0, grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionCrossReference_0_0());
            				

            }


            }

            // InternalPDL3.g:275:3: ( (lv_linkType_1_0= ruleWorkSequenceType ) )
            // InternalPDL3.g:276:4: (lv_linkType_1_0= ruleWorkSequenceType )
            {
            // InternalPDL3.g:276:4: (lv_linkType_1_0= ruleWorkSequenceType )
            // InternalPDL3.g:277:5: lv_linkType_1_0= ruleWorkSequenceType
            {

            					newCompositeNode(grammarAccess.getWorkSequenceAccess().getLinkTypeWorkSequenceTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_linkType_1_0=ruleWorkSequenceType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWorkSequenceRule());
            					}
            					set(
            						current,
            						"linkType",
            						lv_linkType_1_0,
            						"fr.n7.PDL3.WorkSequenceType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPDL3.g:294:3: ( (otherlv_2= RULE_ID ) )
            // InternalPDL3.g:295:4: (otherlv_2= RULE_ID )
            {
            // InternalPDL3.g:295:4: (otherlv_2= RULE_ID )
            // InternalPDL3.g:296:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWorkSequenceRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionCrossReference_2_0());
            				

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


    // $ANTLR start "ruleWorkSequenceType"
    // InternalPDL3.g:311:1: ruleWorkSequenceType returns [Enumerator current=null] : ( (enumLiteral_0= 's2s' ) | (enumLiteral_1= 'f2s' ) | (enumLiteral_2= 's2f' ) | (enumLiteral_3= 'f2f' ) ) ;
    public final Enumerator ruleWorkSequenceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalPDL3.g:317:2: ( ( (enumLiteral_0= 's2s' ) | (enumLiteral_1= 'f2s' ) | (enumLiteral_2= 's2f' ) | (enumLiteral_3= 'f2f' ) ) )
            // InternalPDL3.g:318:2: ( (enumLiteral_0= 's2s' ) | (enumLiteral_1= 'f2s' ) | (enumLiteral_2= 's2f' ) | (enumLiteral_3= 'f2f' ) )
            {
            // InternalPDL3.g:318:2: ( (enumLiteral_0= 's2s' ) | (enumLiteral_1= 'f2s' ) | (enumLiteral_2= 's2f' ) | (enumLiteral_3= 'f2f' ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt4=1;
                }
                break;
            case 16:
                {
                alt4=2;
                }
                break;
            case 17:
                {
                alt4=3;
                }
                break;
            case 18:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalPDL3.g:319:3: (enumLiteral_0= 's2s' )
                    {
                    // InternalPDL3.g:319:3: (enumLiteral_0= 's2s' )
                    // InternalPDL3.g:320:4: enumLiteral_0= 's2s'
                    {
                    enumLiteral_0=(Token)match(input,15,FOLLOW_2); 

                    				current = grammarAccess.getWorkSequenceTypeAccess().getStart2startEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getWorkSequenceTypeAccess().getStart2startEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPDL3.g:327:3: (enumLiteral_1= 'f2s' )
                    {
                    // InternalPDL3.g:327:3: (enumLiteral_1= 'f2s' )
                    // InternalPDL3.g:328:4: enumLiteral_1= 'f2s'
                    {
                    enumLiteral_1=(Token)match(input,16,FOLLOW_2); 

                    				current = grammarAccess.getWorkSequenceTypeAccess().getFinish2startEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getWorkSequenceTypeAccess().getFinish2startEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalPDL3.g:335:3: (enumLiteral_2= 's2f' )
                    {
                    // InternalPDL3.g:335:3: (enumLiteral_2= 's2f' )
                    // InternalPDL3.g:336:4: enumLiteral_2= 's2f'
                    {
                    enumLiteral_2=(Token)match(input,17,FOLLOW_2); 

                    				current = grammarAccess.getWorkSequenceTypeAccess().getStart2finishEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getWorkSequenceTypeAccess().getStart2finishEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalPDL3.g:343:3: (enumLiteral_3= 'f2f' )
                    {
                    // InternalPDL3.g:343:3: (enumLiteral_3= 'f2f' )
                    // InternalPDL3.g:344:4: enumLiteral_3= 'f2f'
                    {
                    enumLiteral_3=(Token)match(input,18,FOLLOW_2); 

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
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000078000L});

}