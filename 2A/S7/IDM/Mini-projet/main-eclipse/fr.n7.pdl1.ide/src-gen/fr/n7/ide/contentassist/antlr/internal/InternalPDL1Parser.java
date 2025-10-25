package fr.n7.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import fr.n7.services.PDL1GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPDL1Parser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'s2s'", "'f2s'", "'s2f'", "'f2f'", "'process'", "'{'", "'}'", "'wd'", "'uses'", "','", "'ws'", "'from'", "'to'", "'note'", "'r'", "'usage'"
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

    	public void setGrammarAccess(PDL1GrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleProcess"
    // InternalPDL1.g:53:1: entryRuleProcess : ruleProcess EOF ;
    public final void entryRuleProcess() throws RecognitionException {
        try {
            // InternalPDL1.g:54:1: ( ruleProcess EOF )
            // InternalPDL1.g:55:1: ruleProcess EOF
            {
             before(grammarAccess.getProcessRule()); 
            pushFollow(FOLLOW_1);
            ruleProcess();

            state._fsp--;

             after(grammarAccess.getProcessRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalPDL1.g:62:1: ruleProcess : ( ( rule__Process__Group__0 ) ) ;
    public final void ruleProcess() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:66:2: ( ( ( rule__Process__Group__0 ) ) )
            // InternalPDL1.g:67:2: ( ( rule__Process__Group__0 ) )
            {
            // InternalPDL1.g:67:2: ( ( rule__Process__Group__0 ) )
            // InternalPDL1.g:68:3: ( rule__Process__Group__0 )
            {
             before(grammarAccess.getProcessAccess().getGroup()); 
            // InternalPDL1.g:69:3: ( rule__Process__Group__0 )
            // InternalPDL1.g:69:4: rule__Process__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleProcessElement"
    // InternalPDL1.g:78:1: entryRuleProcessElement : ruleProcessElement EOF ;
    public final void entryRuleProcessElement() throws RecognitionException {
        try {
            // InternalPDL1.g:79:1: ( ruleProcessElement EOF )
            // InternalPDL1.g:80:1: ruleProcessElement EOF
            {
             before(grammarAccess.getProcessElementRule()); 
            pushFollow(FOLLOW_1);
            ruleProcessElement();

            state._fsp--;

             after(grammarAccess.getProcessElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProcessElement"


    // $ANTLR start "ruleProcessElement"
    // InternalPDL1.g:87:1: ruleProcessElement : ( ( rule__ProcessElement__Alternatives ) ) ;
    public final void ruleProcessElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:91:2: ( ( ( rule__ProcessElement__Alternatives ) ) )
            // InternalPDL1.g:92:2: ( ( rule__ProcessElement__Alternatives ) )
            {
            // InternalPDL1.g:92:2: ( ( rule__ProcessElement__Alternatives ) )
            // InternalPDL1.g:93:3: ( rule__ProcessElement__Alternatives )
            {
             before(grammarAccess.getProcessElementAccess().getAlternatives()); 
            // InternalPDL1.g:94:3: ( rule__ProcessElement__Alternatives )
            // InternalPDL1.g:94:4: rule__ProcessElement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ProcessElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getProcessElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProcessElement"


    // $ANTLR start "entryRuleWorkDefinition"
    // InternalPDL1.g:103:1: entryRuleWorkDefinition : ruleWorkDefinition EOF ;
    public final void entryRuleWorkDefinition() throws RecognitionException {
        try {
            // InternalPDL1.g:104:1: ( ruleWorkDefinition EOF )
            // InternalPDL1.g:105:1: ruleWorkDefinition EOF
            {
             before(grammarAccess.getWorkDefinitionRule()); 
            pushFollow(FOLLOW_1);
            ruleWorkDefinition();

            state._fsp--;

             after(grammarAccess.getWorkDefinitionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWorkDefinition"


    // $ANTLR start "ruleWorkDefinition"
    // InternalPDL1.g:112:1: ruleWorkDefinition : ( ( rule__WorkDefinition__Group__0 ) ) ;
    public final void ruleWorkDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:116:2: ( ( ( rule__WorkDefinition__Group__0 ) ) )
            // InternalPDL1.g:117:2: ( ( rule__WorkDefinition__Group__0 ) )
            {
            // InternalPDL1.g:117:2: ( ( rule__WorkDefinition__Group__0 ) )
            // InternalPDL1.g:118:3: ( rule__WorkDefinition__Group__0 )
            {
             before(grammarAccess.getWorkDefinitionAccess().getGroup()); 
            // InternalPDL1.g:119:3: ( rule__WorkDefinition__Group__0 )
            // InternalPDL1.g:119:4: rule__WorkDefinition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWorkDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkDefinition"


    // $ANTLR start "entryRuleWorkSequence"
    // InternalPDL1.g:128:1: entryRuleWorkSequence : ruleWorkSequence EOF ;
    public final void entryRuleWorkSequence() throws RecognitionException {
        try {
            // InternalPDL1.g:129:1: ( ruleWorkSequence EOF )
            // InternalPDL1.g:130:1: ruleWorkSequence EOF
            {
             before(grammarAccess.getWorkSequenceRule()); 
            pushFollow(FOLLOW_1);
            ruleWorkSequence();

            state._fsp--;

             after(grammarAccess.getWorkSequenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWorkSequence"


    // $ANTLR start "ruleWorkSequence"
    // InternalPDL1.g:137:1: ruleWorkSequence : ( ( rule__WorkSequence__Group__0 ) ) ;
    public final void ruleWorkSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:141:2: ( ( ( rule__WorkSequence__Group__0 ) ) )
            // InternalPDL1.g:142:2: ( ( rule__WorkSequence__Group__0 ) )
            {
            // InternalPDL1.g:142:2: ( ( rule__WorkSequence__Group__0 ) )
            // InternalPDL1.g:143:3: ( rule__WorkSequence__Group__0 )
            {
             before(grammarAccess.getWorkSequenceAccess().getGroup()); 
            // InternalPDL1.g:144:3: ( rule__WorkSequence__Group__0 )
            // InternalPDL1.g:144:4: rule__WorkSequence__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkSequence"


    // $ANTLR start "entryRuleGuidance"
    // InternalPDL1.g:153:1: entryRuleGuidance : ruleGuidance EOF ;
    public final void entryRuleGuidance() throws RecognitionException {
        try {
            // InternalPDL1.g:154:1: ( ruleGuidance EOF )
            // InternalPDL1.g:155:1: ruleGuidance EOF
            {
             before(grammarAccess.getGuidanceRule()); 
            pushFollow(FOLLOW_1);
            ruleGuidance();

            state._fsp--;

             after(grammarAccess.getGuidanceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGuidance"


    // $ANTLR start "ruleGuidance"
    // InternalPDL1.g:162:1: ruleGuidance : ( ( rule__Guidance__Group__0 ) ) ;
    public final void ruleGuidance() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:166:2: ( ( ( rule__Guidance__Group__0 ) ) )
            // InternalPDL1.g:167:2: ( ( rule__Guidance__Group__0 ) )
            {
            // InternalPDL1.g:167:2: ( ( rule__Guidance__Group__0 ) )
            // InternalPDL1.g:168:3: ( rule__Guidance__Group__0 )
            {
             before(grammarAccess.getGuidanceAccess().getGroup()); 
            // InternalPDL1.g:169:3: ( rule__Guidance__Group__0 )
            // InternalPDL1.g:169:4: rule__Guidance__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Guidance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGuidanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGuidance"


    // $ANTLR start "entryRuleResource"
    // InternalPDL1.g:178:1: entryRuleResource : ruleResource EOF ;
    public final void entryRuleResource() throws RecognitionException {
        try {
            // InternalPDL1.g:179:1: ( ruleResource EOF )
            // InternalPDL1.g:180:1: ruleResource EOF
            {
             before(grammarAccess.getResourceRule()); 
            pushFollow(FOLLOW_1);
            ruleResource();

            state._fsp--;

             after(grammarAccess.getResourceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleResource"


    // $ANTLR start "ruleResource"
    // InternalPDL1.g:187:1: ruleResource : ( ( rule__Resource__Group__0 ) ) ;
    public final void ruleResource() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:191:2: ( ( ( rule__Resource__Group__0 ) ) )
            // InternalPDL1.g:192:2: ( ( rule__Resource__Group__0 ) )
            {
            // InternalPDL1.g:192:2: ( ( rule__Resource__Group__0 ) )
            // InternalPDL1.g:193:3: ( rule__Resource__Group__0 )
            {
             before(grammarAccess.getResourceAccess().getGroup()); 
            // InternalPDL1.g:194:3: ( rule__Resource__Group__0 )
            // InternalPDL1.g:194:4: rule__Resource__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Resource__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResourceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResource"


    // $ANTLR start "entryRuleUsageResource"
    // InternalPDL1.g:203:1: entryRuleUsageResource : ruleUsageResource EOF ;
    public final void entryRuleUsageResource() throws RecognitionException {
        try {
            // InternalPDL1.g:204:1: ( ruleUsageResource EOF )
            // InternalPDL1.g:205:1: ruleUsageResource EOF
            {
             before(grammarAccess.getUsageResourceRule()); 
            pushFollow(FOLLOW_1);
            ruleUsageResource();

            state._fsp--;

             after(grammarAccess.getUsageResourceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUsageResource"


    // $ANTLR start "ruleUsageResource"
    // InternalPDL1.g:212:1: ruleUsageResource : ( ( rule__UsageResource__Group__0 ) ) ;
    public final void ruleUsageResource() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:216:2: ( ( ( rule__UsageResource__Group__0 ) ) )
            // InternalPDL1.g:217:2: ( ( rule__UsageResource__Group__0 ) )
            {
            // InternalPDL1.g:217:2: ( ( rule__UsageResource__Group__0 ) )
            // InternalPDL1.g:218:3: ( rule__UsageResource__Group__0 )
            {
             before(grammarAccess.getUsageResourceAccess().getGroup()); 
            // InternalPDL1.g:219:3: ( rule__UsageResource__Group__0 )
            // InternalPDL1.g:219:4: rule__UsageResource__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UsageResource__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUsageResourceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUsageResource"


    // $ANTLR start "ruleWorkSequenceType"
    // InternalPDL1.g:228:1: ruleWorkSequenceType : ( ( rule__WorkSequenceType__Alternatives ) ) ;
    public final void ruleWorkSequenceType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:232:1: ( ( ( rule__WorkSequenceType__Alternatives ) ) )
            // InternalPDL1.g:233:2: ( ( rule__WorkSequenceType__Alternatives ) )
            {
            // InternalPDL1.g:233:2: ( ( rule__WorkSequenceType__Alternatives ) )
            // InternalPDL1.g:234:3: ( rule__WorkSequenceType__Alternatives )
            {
             before(grammarAccess.getWorkSequenceTypeAccess().getAlternatives()); 
            // InternalPDL1.g:235:3: ( rule__WorkSequenceType__Alternatives )
            // InternalPDL1.g:235:4: rule__WorkSequenceType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequenceType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkSequenceType"


    // $ANTLR start "rule__ProcessElement__Alternatives"
    // InternalPDL1.g:243:1: rule__ProcessElement__Alternatives : ( ( ruleWorkDefinition ) | ( ruleWorkSequence ) | ( ruleGuidance ) );
    public final void rule__ProcessElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:247:1: ( ( ruleWorkDefinition ) | ( ruleWorkSequence ) | ( ruleGuidance ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt1=1;
                }
                break;
            case 21:
                {
                alt1=2;
                }
                break;
            case 24:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalPDL1.g:248:2: ( ruleWorkDefinition )
                    {
                    // InternalPDL1.g:248:2: ( ruleWorkDefinition )
                    // InternalPDL1.g:249:3: ruleWorkDefinition
                    {
                     before(grammarAccess.getProcessElementAccess().getWorkDefinitionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleWorkDefinition();

                    state._fsp--;

                     after(grammarAccess.getProcessElementAccess().getWorkDefinitionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPDL1.g:254:2: ( ruleWorkSequence )
                    {
                    // InternalPDL1.g:254:2: ( ruleWorkSequence )
                    // InternalPDL1.g:255:3: ruleWorkSequence
                    {
                     before(grammarAccess.getProcessElementAccess().getWorkSequenceParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleWorkSequence();

                    state._fsp--;

                     after(grammarAccess.getProcessElementAccess().getWorkSequenceParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPDL1.g:260:2: ( ruleGuidance )
                    {
                    // InternalPDL1.g:260:2: ( ruleGuidance )
                    // InternalPDL1.g:261:3: ruleGuidance
                    {
                     before(grammarAccess.getProcessElementAccess().getGuidanceParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleGuidance();

                    state._fsp--;

                     after(grammarAccess.getProcessElementAccess().getGuidanceParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProcessElement__Alternatives"


    // $ANTLR start "rule__WorkSequenceType__Alternatives"
    // InternalPDL1.g:270:1: rule__WorkSequenceType__Alternatives : ( ( ( 's2s' ) ) | ( ( 'f2s' ) ) | ( ( 's2f' ) ) | ( ( 'f2f' ) ) );
    public final void rule__WorkSequenceType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:274:1: ( ( ( 's2s' ) ) | ( ( 'f2s' ) ) | ( ( 's2f' ) ) | ( ( 'f2f' ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalPDL1.g:275:2: ( ( 's2s' ) )
                    {
                    // InternalPDL1.g:275:2: ( ( 's2s' ) )
                    // InternalPDL1.g:276:3: ( 's2s' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getStart2startEnumLiteralDeclaration_0()); 
                    // InternalPDL1.g:277:3: ( 's2s' )
                    // InternalPDL1.g:277:4: 's2s'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getWorkSequenceTypeAccess().getStart2startEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPDL1.g:281:2: ( ( 'f2s' ) )
                    {
                    // InternalPDL1.g:281:2: ( ( 'f2s' ) )
                    // InternalPDL1.g:282:3: ( 'f2s' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getFinish2startEnumLiteralDeclaration_1()); 
                    // InternalPDL1.g:283:3: ( 'f2s' )
                    // InternalPDL1.g:283:4: 'f2s'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getWorkSequenceTypeAccess().getFinish2startEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPDL1.g:287:2: ( ( 's2f' ) )
                    {
                    // InternalPDL1.g:287:2: ( ( 's2f' ) )
                    // InternalPDL1.g:288:3: ( 's2f' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getStart2finishEnumLiteralDeclaration_2()); 
                    // InternalPDL1.g:289:3: ( 's2f' )
                    // InternalPDL1.g:289:4: 's2f'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getWorkSequenceTypeAccess().getStart2finishEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPDL1.g:293:2: ( ( 'f2f' ) )
                    {
                    // InternalPDL1.g:293:2: ( ( 'f2f' ) )
                    // InternalPDL1.g:294:3: ( 'f2f' )
                    {
                     before(grammarAccess.getWorkSequenceTypeAccess().getFinish2finishEnumLiteralDeclaration_3()); 
                    // InternalPDL1.g:295:3: ( 'f2f' )
                    // InternalPDL1.g:295:4: 'f2f'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getWorkSequenceTypeAccess().getFinish2finishEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequenceType__Alternatives"


    // $ANTLR start "rule__Process__Group__0"
    // InternalPDL1.g:303:1: rule__Process__Group__0 : rule__Process__Group__0__Impl rule__Process__Group__1 ;
    public final void rule__Process__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:307:1: ( rule__Process__Group__0__Impl rule__Process__Group__1 )
            // InternalPDL1.g:308:2: rule__Process__Group__0__Impl rule__Process__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Process__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__0"


    // $ANTLR start "rule__Process__Group__0__Impl"
    // InternalPDL1.g:315:1: rule__Process__Group__0__Impl : ( 'process' ) ;
    public final void rule__Process__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:319:1: ( ( 'process' ) )
            // InternalPDL1.g:320:1: ( 'process' )
            {
            // InternalPDL1.g:320:1: ( 'process' )
            // InternalPDL1.g:321:2: 'process'
            {
             before(grammarAccess.getProcessAccess().getProcessKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getProcessKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__0__Impl"


    // $ANTLR start "rule__Process__Group__1"
    // InternalPDL1.g:330:1: rule__Process__Group__1 : rule__Process__Group__1__Impl rule__Process__Group__2 ;
    public final void rule__Process__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:334:1: ( rule__Process__Group__1__Impl rule__Process__Group__2 )
            // InternalPDL1.g:335:2: rule__Process__Group__1__Impl rule__Process__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Process__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__1"


    // $ANTLR start "rule__Process__Group__1__Impl"
    // InternalPDL1.g:342:1: rule__Process__Group__1__Impl : ( ( rule__Process__NameAssignment_1 ) ) ;
    public final void rule__Process__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:346:1: ( ( ( rule__Process__NameAssignment_1 ) ) )
            // InternalPDL1.g:347:1: ( ( rule__Process__NameAssignment_1 ) )
            {
            // InternalPDL1.g:347:1: ( ( rule__Process__NameAssignment_1 ) )
            // InternalPDL1.g:348:2: ( rule__Process__NameAssignment_1 )
            {
             before(grammarAccess.getProcessAccess().getNameAssignment_1()); 
            // InternalPDL1.g:349:2: ( rule__Process__NameAssignment_1 )
            // InternalPDL1.g:349:3: rule__Process__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Process__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__1__Impl"


    // $ANTLR start "rule__Process__Group__2"
    // InternalPDL1.g:357:1: rule__Process__Group__2 : rule__Process__Group__2__Impl rule__Process__Group__3 ;
    public final void rule__Process__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:361:1: ( rule__Process__Group__2__Impl rule__Process__Group__3 )
            // InternalPDL1.g:362:2: rule__Process__Group__2__Impl rule__Process__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Process__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__2"


    // $ANTLR start "rule__Process__Group__2__Impl"
    // InternalPDL1.g:369:1: rule__Process__Group__2__Impl : ( '{' ) ;
    public final void rule__Process__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:373:1: ( ( '{' ) )
            // InternalPDL1.g:374:1: ( '{' )
            {
            // InternalPDL1.g:374:1: ( '{' )
            // InternalPDL1.g:375:2: '{'
            {
             before(grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__2__Impl"


    // $ANTLR start "rule__Process__Group__3"
    // InternalPDL1.g:384:1: rule__Process__Group__3 : rule__Process__Group__3__Impl rule__Process__Group__4 ;
    public final void rule__Process__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:388:1: ( rule__Process__Group__3__Impl rule__Process__Group__4 )
            // InternalPDL1.g:389:2: rule__Process__Group__3__Impl rule__Process__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__Process__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__3"


    // $ANTLR start "rule__Process__Group__3__Impl"
    // InternalPDL1.g:396:1: rule__Process__Group__3__Impl : ( ( rule__Process__ProcessElementsAssignment_3 )* ) ;
    public final void rule__Process__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:400:1: ( ( ( rule__Process__ProcessElementsAssignment_3 )* ) )
            // InternalPDL1.g:401:1: ( ( rule__Process__ProcessElementsAssignment_3 )* )
            {
            // InternalPDL1.g:401:1: ( ( rule__Process__ProcessElementsAssignment_3 )* )
            // InternalPDL1.g:402:2: ( rule__Process__ProcessElementsAssignment_3 )*
            {
             before(grammarAccess.getProcessAccess().getProcessElementsAssignment_3()); 
            // InternalPDL1.g:403:2: ( rule__Process__ProcessElementsAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18||LA3_0==21||LA3_0==24) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPDL1.g:403:3: rule__Process__ProcessElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Process__ProcessElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getProcessAccess().getProcessElementsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__3__Impl"


    // $ANTLR start "rule__Process__Group__4"
    // InternalPDL1.g:411:1: rule__Process__Group__4 : rule__Process__Group__4__Impl rule__Process__Group__5 ;
    public final void rule__Process__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:415:1: ( rule__Process__Group__4__Impl rule__Process__Group__5 )
            // InternalPDL1.g:416:2: rule__Process__Group__4__Impl rule__Process__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__Process__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__4"


    // $ANTLR start "rule__Process__Group__4__Impl"
    // InternalPDL1.g:423:1: rule__Process__Group__4__Impl : ( ( rule__Process__ResourcesAssignment_4 )* ) ;
    public final void rule__Process__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:427:1: ( ( ( rule__Process__ResourcesAssignment_4 )* ) )
            // InternalPDL1.g:428:1: ( ( rule__Process__ResourcesAssignment_4 )* )
            {
            // InternalPDL1.g:428:1: ( ( rule__Process__ResourcesAssignment_4 )* )
            // InternalPDL1.g:429:2: ( rule__Process__ResourcesAssignment_4 )*
            {
             before(grammarAccess.getProcessAccess().getResourcesAssignment_4()); 
            // InternalPDL1.g:430:2: ( rule__Process__ResourcesAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==25) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalPDL1.g:430:3: rule__Process__ResourcesAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Process__ResourcesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getProcessAccess().getResourcesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__4__Impl"


    // $ANTLR start "rule__Process__Group__5"
    // InternalPDL1.g:438:1: rule__Process__Group__5 : rule__Process__Group__5__Impl ;
    public final void rule__Process__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:442:1: ( rule__Process__Group__5__Impl )
            // InternalPDL1.g:443:2: rule__Process__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__5"


    // $ANTLR start "rule__Process__Group__5__Impl"
    // InternalPDL1.g:449:1: rule__Process__Group__5__Impl : ( '}' ) ;
    public final void rule__Process__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:453:1: ( ( '}' ) )
            // InternalPDL1.g:454:1: ( '}' )
            {
            // InternalPDL1.g:454:1: ( '}' )
            // InternalPDL1.g:455:2: '}'
            {
             before(grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_5()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__5__Impl"


    // $ANTLR start "rule__WorkDefinition__Group__0"
    // InternalPDL1.g:465:1: rule__WorkDefinition__Group__0 : rule__WorkDefinition__Group__0__Impl rule__WorkDefinition__Group__1 ;
    public final void rule__WorkDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:469:1: ( rule__WorkDefinition__Group__0__Impl rule__WorkDefinition__Group__1 )
            // InternalPDL1.g:470:2: rule__WorkDefinition__Group__0__Impl rule__WorkDefinition__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__WorkDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group__0"


    // $ANTLR start "rule__WorkDefinition__Group__0__Impl"
    // InternalPDL1.g:477:1: rule__WorkDefinition__Group__0__Impl : ( 'wd' ) ;
    public final void rule__WorkDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:481:1: ( ( 'wd' ) )
            // InternalPDL1.g:482:1: ( 'wd' )
            {
            // InternalPDL1.g:482:1: ( 'wd' )
            // InternalPDL1.g:483:2: 'wd'
            {
             before(grammarAccess.getWorkDefinitionAccess().getWdKeyword_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getWorkDefinitionAccess().getWdKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group__0__Impl"


    // $ANTLR start "rule__WorkDefinition__Group__1"
    // InternalPDL1.g:492:1: rule__WorkDefinition__Group__1 : rule__WorkDefinition__Group__1__Impl rule__WorkDefinition__Group__2 ;
    public final void rule__WorkDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:496:1: ( rule__WorkDefinition__Group__1__Impl rule__WorkDefinition__Group__2 )
            // InternalPDL1.g:497:2: rule__WorkDefinition__Group__1__Impl rule__WorkDefinition__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__WorkDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group__1"


    // $ANTLR start "rule__WorkDefinition__Group__1__Impl"
    // InternalPDL1.g:504:1: rule__WorkDefinition__Group__1__Impl : ( ( rule__WorkDefinition__NameAssignment_1 ) ) ;
    public final void rule__WorkDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:508:1: ( ( ( rule__WorkDefinition__NameAssignment_1 ) ) )
            // InternalPDL1.g:509:1: ( ( rule__WorkDefinition__NameAssignment_1 ) )
            {
            // InternalPDL1.g:509:1: ( ( rule__WorkDefinition__NameAssignment_1 ) )
            // InternalPDL1.g:510:2: ( rule__WorkDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getWorkDefinitionAccess().getNameAssignment_1()); 
            // InternalPDL1.g:511:2: ( rule__WorkDefinition__NameAssignment_1 )
            // InternalPDL1.g:511:3: rule__WorkDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWorkDefinitionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group__1__Impl"


    // $ANTLR start "rule__WorkDefinition__Group__2"
    // InternalPDL1.g:519:1: rule__WorkDefinition__Group__2 : rule__WorkDefinition__Group__2__Impl ;
    public final void rule__WorkDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:523:1: ( rule__WorkDefinition__Group__2__Impl )
            // InternalPDL1.g:524:2: rule__WorkDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group__2"


    // $ANTLR start "rule__WorkDefinition__Group__2__Impl"
    // InternalPDL1.g:530:1: rule__WorkDefinition__Group__2__Impl : ( ( rule__WorkDefinition__Group_2__0 )? ) ;
    public final void rule__WorkDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:534:1: ( ( ( rule__WorkDefinition__Group_2__0 )? ) )
            // InternalPDL1.g:535:1: ( ( rule__WorkDefinition__Group_2__0 )? )
            {
            // InternalPDL1.g:535:1: ( ( rule__WorkDefinition__Group_2__0 )? )
            // InternalPDL1.g:536:2: ( rule__WorkDefinition__Group_2__0 )?
            {
             before(grammarAccess.getWorkDefinitionAccess().getGroup_2()); 
            // InternalPDL1.g:537:2: ( rule__WorkDefinition__Group_2__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalPDL1.g:537:3: rule__WorkDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__WorkDefinition__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getWorkDefinitionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group__2__Impl"


    // $ANTLR start "rule__WorkDefinition__Group_2__0"
    // InternalPDL1.g:546:1: rule__WorkDefinition__Group_2__0 : rule__WorkDefinition__Group_2__0__Impl rule__WorkDefinition__Group_2__1 ;
    public final void rule__WorkDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:550:1: ( rule__WorkDefinition__Group_2__0__Impl rule__WorkDefinition__Group_2__1 )
            // InternalPDL1.g:551:2: rule__WorkDefinition__Group_2__0__Impl rule__WorkDefinition__Group_2__1
            {
            pushFollow(FOLLOW_9);
            rule__WorkDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group_2__0"


    // $ANTLR start "rule__WorkDefinition__Group_2__0__Impl"
    // InternalPDL1.g:558:1: rule__WorkDefinition__Group_2__0__Impl : ( 'uses' ) ;
    public final void rule__WorkDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:562:1: ( ( 'uses' ) )
            // InternalPDL1.g:563:1: ( 'uses' )
            {
            // InternalPDL1.g:563:1: ( 'uses' )
            // InternalPDL1.g:564:2: 'uses'
            {
             before(grammarAccess.getWorkDefinitionAccess().getUsesKeyword_2_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getWorkDefinitionAccess().getUsesKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group_2__0__Impl"


    // $ANTLR start "rule__WorkDefinition__Group_2__1"
    // InternalPDL1.g:573:1: rule__WorkDefinition__Group_2__1 : rule__WorkDefinition__Group_2__1__Impl rule__WorkDefinition__Group_2__2 ;
    public final void rule__WorkDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:577:1: ( rule__WorkDefinition__Group_2__1__Impl rule__WorkDefinition__Group_2__2 )
            // InternalPDL1.g:578:2: rule__WorkDefinition__Group_2__1__Impl rule__WorkDefinition__Group_2__2
            {
            pushFollow(FOLLOW_10);
            rule__WorkDefinition__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group_2__1"


    // $ANTLR start "rule__WorkDefinition__Group_2__1__Impl"
    // InternalPDL1.g:585:1: rule__WorkDefinition__Group_2__1__Impl : ( ( rule__WorkDefinition__UsageresourcesAssignment_2_1 ) ) ;
    public final void rule__WorkDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:589:1: ( ( ( rule__WorkDefinition__UsageresourcesAssignment_2_1 ) ) )
            // InternalPDL1.g:590:1: ( ( rule__WorkDefinition__UsageresourcesAssignment_2_1 ) )
            {
            // InternalPDL1.g:590:1: ( ( rule__WorkDefinition__UsageresourcesAssignment_2_1 ) )
            // InternalPDL1.g:591:2: ( rule__WorkDefinition__UsageresourcesAssignment_2_1 )
            {
             before(grammarAccess.getWorkDefinitionAccess().getUsageresourcesAssignment_2_1()); 
            // InternalPDL1.g:592:2: ( rule__WorkDefinition__UsageresourcesAssignment_2_1 )
            // InternalPDL1.g:592:3: rule__WorkDefinition__UsageresourcesAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__UsageresourcesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getWorkDefinitionAccess().getUsageresourcesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group_2__1__Impl"


    // $ANTLR start "rule__WorkDefinition__Group_2__2"
    // InternalPDL1.g:600:1: rule__WorkDefinition__Group_2__2 : rule__WorkDefinition__Group_2__2__Impl ;
    public final void rule__WorkDefinition__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:604:1: ( rule__WorkDefinition__Group_2__2__Impl )
            // InternalPDL1.g:605:2: rule__WorkDefinition__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group_2__2"


    // $ANTLR start "rule__WorkDefinition__Group_2__2__Impl"
    // InternalPDL1.g:611:1: rule__WorkDefinition__Group_2__2__Impl : ( ( rule__WorkDefinition__Group_2_2__0 )* ) ;
    public final void rule__WorkDefinition__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:615:1: ( ( ( rule__WorkDefinition__Group_2_2__0 )* ) )
            // InternalPDL1.g:616:1: ( ( rule__WorkDefinition__Group_2_2__0 )* )
            {
            // InternalPDL1.g:616:1: ( ( rule__WorkDefinition__Group_2_2__0 )* )
            // InternalPDL1.g:617:2: ( rule__WorkDefinition__Group_2_2__0 )*
            {
             before(grammarAccess.getWorkDefinitionAccess().getGroup_2_2()); 
            // InternalPDL1.g:618:2: ( rule__WorkDefinition__Group_2_2__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalPDL1.g:618:3: rule__WorkDefinition__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__WorkDefinition__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getWorkDefinitionAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group_2__2__Impl"


    // $ANTLR start "rule__WorkDefinition__Group_2_2__0"
    // InternalPDL1.g:627:1: rule__WorkDefinition__Group_2_2__0 : rule__WorkDefinition__Group_2_2__0__Impl rule__WorkDefinition__Group_2_2__1 ;
    public final void rule__WorkDefinition__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:631:1: ( rule__WorkDefinition__Group_2_2__0__Impl rule__WorkDefinition__Group_2_2__1 )
            // InternalPDL1.g:632:2: rule__WorkDefinition__Group_2_2__0__Impl rule__WorkDefinition__Group_2_2__1
            {
            pushFollow(FOLLOW_9);
            rule__WorkDefinition__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group_2_2__0"


    // $ANTLR start "rule__WorkDefinition__Group_2_2__0__Impl"
    // InternalPDL1.g:639:1: rule__WorkDefinition__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__WorkDefinition__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:643:1: ( ( ',' ) )
            // InternalPDL1.g:644:1: ( ',' )
            {
            // InternalPDL1.g:644:1: ( ',' )
            // InternalPDL1.g:645:2: ','
            {
             before(grammarAccess.getWorkDefinitionAccess().getCommaKeyword_2_2_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getWorkDefinitionAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group_2_2__0__Impl"


    // $ANTLR start "rule__WorkDefinition__Group_2_2__1"
    // InternalPDL1.g:654:1: rule__WorkDefinition__Group_2_2__1 : rule__WorkDefinition__Group_2_2__1__Impl ;
    public final void rule__WorkDefinition__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:658:1: ( rule__WorkDefinition__Group_2_2__1__Impl )
            // InternalPDL1.g:659:2: rule__WorkDefinition__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group_2_2__1"


    // $ANTLR start "rule__WorkDefinition__Group_2_2__1__Impl"
    // InternalPDL1.g:665:1: rule__WorkDefinition__Group_2_2__1__Impl : ( ( rule__WorkDefinition__UseagesAssignment_2_2_1 ) ) ;
    public final void rule__WorkDefinition__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:669:1: ( ( ( rule__WorkDefinition__UseagesAssignment_2_2_1 ) ) )
            // InternalPDL1.g:670:1: ( ( rule__WorkDefinition__UseagesAssignment_2_2_1 ) )
            {
            // InternalPDL1.g:670:1: ( ( rule__WorkDefinition__UseagesAssignment_2_2_1 ) )
            // InternalPDL1.g:671:2: ( rule__WorkDefinition__UseagesAssignment_2_2_1 )
            {
             before(grammarAccess.getWorkDefinitionAccess().getUseagesAssignment_2_2_1()); 
            // InternalPDL1.g:672:2: ( rule__WorkDefinition__UseagesAssignment_2_2_1 )
            // InternalPDL1.g:672:3: rule__WorkDefinition__UseagesAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__WorkDefinition__UseagesAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getWorkDefinitionAccess().getUseagesAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__Group_2_2__1__Impl"


    // $ANTLR start "rule__WorkSequence__Group__0"
    // InternalPDL1.g:681:1: rule__WorkSequence__Group__0 : rule__WorkSequence__Group__0__Impl rule__WorkSequence__Group__1 ;
    public final void rule__WorkSequence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:685:1: ( rule__WorkSequence__Group__0__Impl rule__WorkSequence__Group__1 )
            // InternalPDL1.g:686:2: rule__WorkSequence__Group__0__Impl rule__WorkSequence__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__WorkSequence__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__0"


    // $ANTLR start "rule__WorkSequence__Group__0__Impl"
    // InternalPDL1.g:693:1: rule__WorkSequence__Group__0__Impl : ( 'ws' ) ;
    public final void rule__WorkSequence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:697:1: ( ( 'ws' ) )
            // InternalPDL1.g:698:1: ( 'ws' )
            {
            // InternalPDL1.g:698:1: ( 'ws' )
            // InternalPDL1.g:699:2: 'ws'
            {
             before(grammarAccess.getWorkSequenceAccess().getWsKeyword_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getWsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__0__Impl"


    // $ANTLR start "rule__WorkSequence__Group__1"
    // InternalPDL1.g:708:1: rule__WorkSequence__Group__1 : rule__WorkSequence__Group__1__Impl rule__WorkSequence__Group__2 ;
    public final void rule__WorkSequence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:712:1: ( rule__WorkSequence__Group__1__Impl rule__WorkSequence__Group__2 )
            // InternalPDL1.g:713:2: rule__WorkSequence__Group__1__Impl rule__WorkSequence__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__WorkSequence__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__1"


    // $ANTLR start "rule__WorkSequence__Group__1__Impl"
    // InternalPDL1.g:720:1: rule__WorkSequence__Group__1__Impl : ( ( rule__WorkSequence__LinkTypeAssignment_1 ) ) ;
    public final void rule__WorkSequence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:724:1: ( ( ( rule__WorkSequence__LinkTypeAssignment_1 ) ) )
            // InternalPDL1.g:725:1: ( ( rule__WorkSequence__LinkTypeAssignment_1 ) )
            {
            // InternalPDL1.g:725:1: ( ( rule__WorkSequence__LinkTypeAssignment_1 ) )
            // InternalPDL1.g:726:2: ( rule__WorkSequence__LinkTypeAssignment_1 )
            {
             before(grammarAccess.getWorkSequenceAccess().getLinkTypeAssignment_1()); 
            // InternalPDL1.g:727:2: ( rule__WorkSequence__LinkTypeAssignment_1 )
            // InternalPDL1.g:727:3: rule__WorkSequence__LinkTypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__LinkTypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceAccess().getLinkTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__1__Impl"


    // $ANTLR start "rule__WorkSequence__Group__2"
    // InternalPDL1.g:735:1: rule__WorkSequence__Group__2 : rule__WorkSequence__Group__2__Impl rule__WorkSequence__Group__3 ;
    public final void rule__WorkSequence__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:739:1: ( rule__WorkSequence__Group__2__Impl rule__WorkSequence__Group__3 )
            // InternalPDL1.g:740:2: rule__WorkSequence__Group__2__Impl rule__WorkSequence__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__WorkSequence__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__2"


    // $ANTLR start "rule__WorkSequence__Group__2__Impl"
    // InternalPDL1.g:747:1: rule__WorkSequence__Group__2__Impl : ( 'from' ) ;
    public final void rule__WorkSequence__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:751:1: ( ( 'from' ) )
            // InternalPDL1.g:752:1: ( 'from' )
            {
            // InternalPDL1.g:752:1: ( 'from' )
            // InternalPDL1.g:753:2: 'from'
            {
             before(grammarAccess.getWorkSequenceAccess().getFromKeyword_2()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getFromKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__2__Impl"


    // $ANTLR start "rule__WorkSequence__Group__3"
    // InternalPDL1.g:762:1: rule__WorkSequence__Group__3 : rule__WorkSequence__Group__3__Impl rule__WorkSequence__Group__4 ;
    public final void rule__WorkSequence__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:766:1: ( rule__WorkSequence__Group__3__Impl rule__WorkSequence__Group__4 )
            // InternalPDL1.g:767:2: rule__WorkSequence__Group__3__Impl rule__WorkSequence__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__WorkSequence__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__3"


    // $ANTLR start "rule__WorkSequence__Group__3__Impl"
    // InternalPDL1.g:774:1: rule__WorkSequence__Group__3__Impl : ( ( rule__WorkSequence__PredecessorAssignment_3 ) ) ;
    public final void rule__WorkSequence__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:778:1: ( ( ( rule__WorkSequence__PredecessorAssignment_3 ) ) )
            // InternalPDL1.g:779:1: ( ( rule__WorkSequence__PredecessorAssignment_3 ) )
            {
            // InternalPDL1.g:779:1: ( ( rule__WorkSequence__PredecessorAssignment_3 ) )
            // InternalPDL1.g:780:2: ( rule__WorkSequence__PredecessorAssignment_3 )
            {
             before(grammarAccess.getWorkSequenceAccess().getPredecessorAssignment_3()); 
            // InternalPDL1.g:781:2: ( rule__WorkSequence__PredecessorAssignment_3 )
            // InternalPDL1.g:781:3: rule__WorkSequence__PredecessorAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__PredecessorAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceAccess().getPredecessorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__3__Impl"


    // $ANTLR start "rule__WorkSequence__Group__4"
    // InternalPDL1.g:789:1: rule__WorkSequence__Group__4 : rule__WorkSequence__Group__4__Impl rule__WorkSequence__Group__5 ;
    public final void rule__WorkSequence__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:793:1: ( rule__WorkSequence__Group__4__Impl rule__WorkSequence__Group__5 )
            // InternalPDL1.g:794:2: rule__WorkSequence__Group__4__Impl rule__WorkSequence__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__WorkSequence__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__4"


    // $ANTLR start "rule__WorkSequence__Group__4__Impl"
    // InternalPDL1.g:801:1: rule__WorkSequence__Group__4__Impl : ( 'to' ) ;
    public final void rule__WorkSequence__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:805:1: ( ( 'to' ) )
            // InternalPDL1.g:806:1: ( 'to' )
            {
            // InternalPDL1.g:806:1: ( 'to' )
            // InternalPDL1.g:807:2: 'to'
            {
             before(grammarAccess.getWorkSequenceAccess().getToKeyword_4()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getToKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__4__Impl"


    // $ANTLR start "rule__WorkSequence__Group__5"
    // InternalPDL1.g:816:1: rule__WorkSequence__Group__5 : rule__WorkSequence__Group__5__Impl ;
    public final void rule__WorkSequence__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:820:1: ( rule__WorkSequence__Group__5__Impl )
            // InternalPDL1.g:821:2: rule__WorkSequence__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__5"


    // $ANTLR start "rule__WorkSequence__Group__5__Impl"
    // InternalPDL1.g:827:1: rule__WorkSequence__Group__5__Impl : ( ( rule__WorkSequence__SuccessorAssignment_5 ) ) ;
    public final void rule__WorkSequence__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:831:1: ( ( ( rule__WorkSequence__SuccessorAssignment_5 ) ) )
            // InternalPDL1.g:832:1: ( ( rule__WorkSequence__SuccessorAssignment_5 ) )
            {
            // InternalPDL1.g:832:1: ( ( rule__WorkSequence__SuccessorAssignment_5 ) )
            // InternalPDL1.g:833:2: ( rule__WorkSequence__SuccessorAssignment_5 )
            {
             before(grammarAccess.getWorkSequenceAccess().getSuccessorAssignment_5()); 
            // InternalPDL1.g:834:2: ( rule__WorkSequence__SuccessorAssignment_5 )
            // InternalPDL1.g:834:3: rule__WorkSequence__SuccessorAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__WorkSequence__SuccessorAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getWorkSequenceAccess().getSuccessorAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__Group__5__Impl"


    // $ANTLR start "rule__Guidance__Group__0"
    // InternalPDL1.g:843:1: rule__Guidance__Group__0 : rule__Guidance__Group__0__Impl rule__Guidance__Group__1 ;
    public final void rule__Guidance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:847:1: ( rule__Guidance__Group__0__Impl rule__Guidance__Group__1 )
            // InternalPDL1.g:848:2: rule__Guidance__Group__0__Impl rule__Guidance__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Guidance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Guidance__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guidance__Group__0"


    // $ANTLR start "rule__Guidance__Group__0__Impl"
    // InternalPDL1.g:855:1: rule__Guidance__Group__0__Impl : ( 'note' ) ;
    public final void rule__Guidance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:859:1: ( ( 'note' ) )
            // InternalPDL1.g:860:1: ( 'note' )
            {
            // InternalPDL1.g:860:1: ( 'note' )
            // InternalPDL1.g:861:2: 'note'
            {
             before(grammarAccess.getGuidanceAccess().getNoteKeyword_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getGuidanceAccess().getNoteKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guidance__Group__0__Impl"


    // $ANTLR start "rule__Guidance__Group__1"
    // InternalPDL1.g:870:1: rule__Guidance__Group__1 : rule__Guidance__Group__1__Impl ;
    public final void rule__Guidance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:874:1: ( rule__Guidance__Group__1__Impl )
            // InternalPDL1.g:875:2: rule__Guidance__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Guidance__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guidance__Group__1"


    // $ANTLR start "rule__Guidance__Group__1__Impl"
    // InternalPDL1.g:881:1: rule__Guidance__Group__1__Impl : ( ( rule__Guidance__TexteAssignment_1 ) ) ;
    public final void rule__Guidance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:885:1: ( ( ( rule__Guidance__TexteAssignment_1 ) ) )
            // InternalPDL1.g:886:1: ( ( rule__Guidance__TexteAssignment_1 ) )
            {
            // InternalPDL1.g:886:1: ( ( rule__Guidance__TexteAssignment_1 ) )
            // InternalPDL1.g:887:2: ( rule__Guidance__TexteAssignment_1 )
            {
             before(grammarAccess.getGuidanceAccess().getTexteAssignment_1()); 
            // InternalPDL1.g:888:2: ( rule__Guidance__TexteAssignment_1 )
            // InternalPDL1.g:888:3: rule__Guidance__TexteAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Guidance__TexteAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGuidanceAccess().getTexteAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guidance__Group__1__Impl"


    // $ANTLR start "rule__Resource__Group__0"
    // InternalPDL1.g:897:1: rule__Resource__Group__0 : rule__Resource__Group__0__Impl rule__Resource__Group__1 ;
    public final void rule__Resource__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:901:1: ( rule__Resource__Group__0__Impl rule__Resource__Group__1 )
            // InternalPDL1.g:902:2: rule__Resource__Group__0__Impl rule__Resource__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Resource__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Resource__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resource__Group__0"


    // $ANTLR start "rule__Resource__Group__0__Impl"
    // InternalPDL1.g:909:1: rule__Resource__Group__0__Impl : ( 'r' ) ;
    public final void rule__Resource__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:913:1: ( ( 'r' ) )
            // InternalPDL1.g:914:1: ( 'r' )
            {
            // InternalPDL1.g:914:1: ( 'r' )
            // InternalPDL1.g:915:2: 'r'
            {
             before(grammarAccess.getResourceAccess().getRKeyword_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getResourceAccess().getRKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resource__Group__0__Impl"


    // $ANTLR start "rule__Resource__Group__1"
    // InternalPDL1.g:924:1: rule__Resource__Group__1 : rule__Resource__Group__1__Impl rule__Resource__Group__2 ;
    public final void rule__Resource__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:928:1: ( rule__Resource__Group__1__Impl rule__Resource__Group__2 )
            // InternalPDL1.g:929:2: rule__Resource__Group__1__Impl rule__Resource__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__Resource__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Resource__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resource__Group__1"


    // $ANTLR start "rule__Resource__Group__1__Impl"
    // InternalPDL1.g:936:1: rule__Resource__Group__1__Impl : ( ( rule__Resource__NameAssignment_1 ) ) ;
    public final void rule__Resource__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:940:1: ( ( ( rule__Resource__NameAssignment_1 ) ) )
            // InternalPDL1.g:941:1: ( ( rule__Resource__NameAssignment_1 ) )
            {
            // InternalPDL1.g:941:1: ( ( rule__Resource__NameAssignment_1 ) )
            // InternalPDL1.g:942:2: ( rule__Resource__NameAssignment_1 )
            {
             before(grammarAccess.getResourceAccess().getNameAssignment_1()); 
            // InternalPDL1.g:943:2: ( rule__Resource__NameAssignment_1 )
            // InternalPDL1.g:943:3: rule__Resource__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Resource__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getResourceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resource__Group__1__Impl"


    // $ANTLR start "rule__Resource__Group__2"
    // InternalPDL1.g:951:1: rule__Resource__Group__2 : rule__Resource__Group__2__Impl rule__Resource__Group__3 ;
    public final void rule__Resource__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:955:1: ( rule__Resource__Group__2__Impl rule__Resource__Group__3 )
            // InternalPDL1.g:956:2: rule__Resource__Group__2__Impl rule__Resource__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__Resource__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Resource__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resource__Group__2"


    // $ANTLR start "rule__Resource__Group__2__Impl"
    // InternalPDL1.g:963:1: rule__Resource__Group__2__Impl : ( ( rule__Resource__QuantityAssignment_2 ) ) ;
    public final void rule__Resource__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:967:1: ( ( ( rule__Resource__QuantityAssignment_2 ) ) )
            // InternalPDL1.g:968:1: ( ( rule__Resource__QuantityAssignment_2 ) )
            {
            // InternalPDL1.g:968:1: ( ( rule__Resource__QuantityAssignment_2 ) )
            // InternalPDL1.g:969:2: ( rule__Resource__QuantityAssignment_2 )
            {
             before(grammarAccess.getResourceAccess().getQuantityAssignment_2()); 
            // InternalPDL1.g:970:2: ( rule__Resource__QuantityAssignment_2 )
            // InternalPDL1.g:970:3: rule__Resource__QuantityAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Resource__QuantityAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getResourceAccess().getQuantityAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resource__Group__2__Impl"


    // $ANTLR start "rule__Resource__Group__3"
    // InternalPDL1.g:978:1: rule__Resource__Group__3 : rule__Resource__Group__3__Impl ;
    public final void rule__Resource__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:982:1: ( rule__Resource__Group__3__Impl )
            // InternalPDL1.g:983:2: rule__Resource__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Resource__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resource__Group__3"


    // $ANTLR start "rule__Resource__Group__3__Impl"
    // InternalPDL1.g:989:1: rule__Resource__Group__3__Impl : ( ( rule__Resource__DescriptionAssignment_3 )? ) ;
    public final void rule__Resource__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:993:1: ( ( ( rule__Resource__DescriptionAssignment_3 )? ) )
            // InternalPDL1.g:994:1: ( ( rule__Resource__DescriptionAssignment_3 )? )
            {
            // InternalPDL1.g:994:1: ( ( rule__Resource__DescriptionAssignment_3 )? )
            // InternalPDL1.g:995:2: ( rule__Resource__DescriptionAssignment_3 )?
            {
             before(grammarAccess.getResourceAccess().getDescriptionAssignment_3()); 
            // InternalPDL1.g:996:2: ( rule__Resource__DescriptionAssignment_3 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalPDL1.g:996:3: rule__Resource__DescriptionAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Resource__DescriptionAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResourceAccess().getDescriptionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resource__Group__3__Impl"


    // $ANTLR start "rule__UsageResource__Group__0"
    // InternalPDL1.g:1005:1: rule__UsageResource__Group__0 : rule__UsageResource__Group__0__Impl rule__UsageResource__Group__1 ;
    public final void rule__UsageResource__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1009:1: ( rule__UsageResource__Group__0__Impl rule__UsageResource__Group__1 )
            // InternalPDL1.g:1010:2: rule__UsageResource__Group__0__Impl rule__UsageResource__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__UsageResource__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UsageResource__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UsageResource__Group__0"


    // $ANTLR start "rule__UsageResource__Group__0__Impl"
    // InternalPDL1.g:1017:1: rule__UsageResource__Group__0__Impl : ( 'usage' ) ;
    public final void rule__UsageResource__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1021:1: ( ( 'usage' ) )
            // InternalPDL1.g:1022:1: ( 'usage' )
            {
            // InternalPDL1.g:1022:1: ( 'usage' )
            // InternalPDL1.g:1023:2: 'usage'
            {
             before(grammarAccess.getUsageResourceAccess().getUsageKeyword_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getUsageResourceAccess().getUsageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UsageResource__Group__0__Impl"


    // $ANTLR start "rule__UsageResource__Group__1"
    // InternalPDL1.g:1032:1: rule__UsageResource__Group__1 : rule__UsageResource__Group__1__Impl rule__UsageResource__Group__2 ;
    public final void rule__UsageResource__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1036:1: ( rule__UsageResource__Group__1__Impl rule__UsageResource__Group__2 )
            // InternalPDL1.g:1037:2: rule__UsageResource__Group__1__Impl rule__UsageResource__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__UsageResource__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UsageResource__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UsageResource__Group__1"


    // $ANTLR start "rule__UsageResource__Group__1__Impl"
    // InternalPDL1.g:1044:1: rule__UsageResource__Group__1__Impl : ( ( rule__UsageResource__ResourceAssignment_1 ) ) ;
    public final void rule__UsageResource__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1048:1: ( ( ( rule__UsageResource__ResourceAssignment_1 ) ) )
            // InternalPDL1.g:1049:1: ( ( rule__UsageResource__ResourceAssignment_1 ) )
            {
            // InternalPDL1.g:1049:1: ( ( rule__UsageResource__ResourceAssignment_1 ) )
            // InternalPDL1.g:1050:2: ( rule__UsageResource__ResourceAssignment_1 )
            {
             before(grammarAccess.getUsageResourceAccess().getResourceAssignment_1()); 
            // InternalPDL1.g:1051:2: ( rule__UsageResource__ResourceAssignment_1 )
            // InternalPDL1.g:1051:3: rule__UsageResource__ResourceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__UsageResource__ResourceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUsageResourceAccess().getResourceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UsageResource__Group__1__Impl"


    // $ANTLR start "rule__UsageResource__Group__2"
    // InternalPDL1.g:1059:1: rule__UsageResource__Group__2 : rule__UsageResource__Group__2__Impl rule__UsageResource__Group__3 ;
    public final void rule__UsageResource__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1063:1: ( rule__UsageResource__Group__2__Impl rule__UsageResource__Group__3 )
            // InternalPDL1.g:1064:2: rule__UsageResource__Group__2__Impl rule__UsageResource__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__UsageResource__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UsageResource__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UsageResource__Group__2"


    // $ANTLR start "rule__UsageResource__Group__2__Impl"
    // InternalPDL1.g:1071:1: rule__UsageResource__Group__2__Impl : ( ( rule__UsageResource__UsageQuantityAssignment_2 ) ) ;
    public final void rule__UsageResource__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1075:1: ( ( ( rule__UsageResource__UsageQuantityAssignment_2 ) ) )
            // InternalPDL1.g:1076:1: ( ( rule__UsageResource__UsageQuantityAssignment_2 ) )
            {
            // InternalPDL1.g:1076:1: ( ( rule__UsageResource__UsageQuantityAssignment_2 ) )
            // InternalPDL1.g:1077:2: ( rule__UsageResource__UsageQuantityAssignment_2 )
            {
             before(grammarAccess.getUsageResourceAccess().getUsageQuantityAssignment_2()); 
            // InternalPDL1.g:1078:2: ( rule__UsageResource__UsageQuantityAssignment_2 )
            // InternalPDL1.g:1078:3: rule__UsageResource__UsageQuantityAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__UsageResource__UsageQuantityAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getUsageResourceAccess().getUsageQuantityAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UsageResource__Group__2__Impl"


    // $ANTLR start "rule__UsageResource__Group__3"
    // InternalPDL1.g:1086:1: rule__UsageResource__Group__3 : rule__UsageResource__Group__3__Impl ;
    public final void rule__UsageResource__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1090:1: ( rule__UsageResource__Group__3__Impl )
            // InternalPDL1.g:1091:2: rule__UsageResource__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UsageResource__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UsageResource__Group__3"


    // $ANTLR start "rule__UsageResource__Group__3__Impl"
    // InternalPDL1.g:1097:1: rule__UsageResource__Group__3__Impl : ( ( rule__UsageResource__UsageTimeAssignment_3 )? ) ;
    public final void rule__UsageResource__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1101:1: ( ( ( rule__UsageResource__UsageTimeAssignment_3 )? ) )
            // InternalPDL1.g:1102:1: ( ( rule__UsageResource__UsageTimeAssignment_3 )? )
            {
            // InternalPDL1.g:1102:1: ( ( rule__UsageResource__UsageTimeAssignment_3 )? )
            // InternalPDL1.g:1103:2: ( rule__UsageResource__UsageTimeAssignment_3 )?
            {
             before(grammarAccess.getUsageResourceAccess().getUsageTimeAssignment_3()); 
            // InternalPDL1.g:1104:2: ( rule__UsageResource__UsageTimeAssignment_3 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalPDL1.g:1104:3: rule__UsageResource__UsageTimeAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__UsageResource__UsageTimeAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getUsageResourceAccess().getUsageTimeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UsageResource__Group__3__Impl"


    // $ANTLR start "rule__Process__NameAssignment_1"
    // InternalPDL1.g:1113:1: rule__Process__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Process__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1117:1: ( ( RULE_ID ) )
            // InternalPDL1.g:1118:2: ( RULE_ID )
            {
            // InternalPDL1.g:1118:2: ( RULE_ID )
            // InternalPDL1.g:1119:3: RULE_ID
            {
             before(grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__NameAssignment_1"


    // $ANTLR start "rule__Process__ProcessElementsAssignment_3"
    // InternalPDL1.g:1128:1: rule__Process__ProcessElementsAssignment_3 : ( ruleProcessElement ) ;
    public final void rule__Process__ProcessElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1132:1: ( ( ruleProcessElement ) )
            // InternalPDL1.g:1133:2: ( ruleProcessElement )
            {
            // InternalPDL1.g:1133:2: ( ruleProcessElement )
            // InternalPDL1.g:1134:3: ruleProcessElement
            {
             before(grammarAccess.getProcessAccess().getProcessElementsProcessElementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleProcessElement();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getProcessElementsProcessElementParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__ProcessElementsAssignment_3"


    // $ANTLR start "rule__Process__ResourcesAssignment_4"
    // InternalPDL1.g:1143:1: rule__Process__ResourcesAssignment_4 : ( ruleResource ) ;
    public final void rule__Process__ResourcesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1147:1: ( ( ruleResource ) )
            // InternalPDL1.g:1148:2: ( ruleResource )
            {
            // InternalPDL1.g:1148:2: ( ruleResource )
            // InternalPDL1.g:1149:3: ruleResource
            {
             before(grammarAccess.getProcessAccess().getResourcesResourceParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleResource();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getResourcesResourceParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__ResourcesAssignment_4"


    // $ANTLR start "rule__WorkDefinition__NameAssignment_1"
    // InternalPDL1.g:1158:1: rule__WorkDefinition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__WorkDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1162:1: ( ( RULE_ID ) )
            // InternalPDL1.g:1163:2: ( RULE_ID )
            {
            // InternalPDL1.g:1163:2: ( RULE_ID )
            // InternalPDL1.g:1164:3: RULE_ID
            {
             before(grammarAccess.getWorkDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWorkDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__NameAssignment_1"


    // $ANTLR start "rule__WorkDefinition__UsageresourcesAssignment_2_1"
    // InternalPDL1.g:1173:1: rule__WorkDefinition__UsageresourcesAssignment_2_1 : ( ruleUsageResource ) ;
    public final void rule__WorkDefinition__UsageresourcesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1177:1: ( ( ruleUsageResource ) )
            // InternalPDL1.g:1178:2: ( ruleUsageResource )
            {
            // InternalPDL1.g:1178:2: ( ruleUsageResource )
            // InternalPDL1.g:1179:3: ruleUsageResource
            {
             before(grammarAccess.getWorkDefinitionAccess().getUsageresourcesUsageResourceParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUsageResource();

            state._fsp--;

             after(grammarAccess.getWorkDefinitionAccess().getUsageresourcesUsageResourceParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__UsageresourcesAssignment_2_1"


    // $ANTLR start "rule__WorkDefinition__UseagesAssignment_2_2_1"
    // InternalPDL1.g:1188:1: rule__WorkDefinition__UseagesAssignment_2_2_1 : ( ruleUsageResource ) ;
    public final void rule__WorkDefinition__UseagesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1192:1: ( ( ruleUsageResource ) )
            // InternalPDL1.g:1193:2: ( ruleUsageResource )
            {
            // InternalPDL1.g:1193:2: ( ruleUsageResource )
            // InternalPDL1.g:1194:3: ruleUsageResource
            {
             before(grammarAccess.getWorkDefinitionAccess().getUseagesUsageResourceParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUsageResource();

            state._fsp--;

             after(grammarAccess.getWorkDefinitionAccess().getUseagesUsageResourceParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkDefinition__UseagesAssignment_2_2_1"


    // $ANTLR start "rule__WorkSequence__LinkTypeAssignment_1"
    // InternalPDL1.g:1203:1: rule__WorkSequence__LinkTypeAssignment_1 : ( ruleWorkSequenceType ) ;
    public final void rule__WorkSequence__LinkTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1207:1: ( ( ruleWorkSequenceType ) )
            // InternalPDL1.g:1208:2: ( ruleWorkSequenceType )
            {
            // InternalPDL1.g:1208:2: ( ruleWorkSequenceType )
            // InternalPDL1.g:1209:3: ruleWorkSequenceType
            {
             before(grammarAccess.getWorkSequenceAccess().getLinkTypeWorkSequenceTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkSequenceType();

            state._fsp--;

             after(grammarAccess.getWorkSequenceAccess().getLinkTypeWorkSequenceTypeEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__LinkTypeAssignment_1"


    // $ANTLR start "rule__WorkSequence__PredecessorAssignment_3"
    // InternalPDL1.g:1218:1: rule__WorkSequence__PredecessorAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__WorkSequence__PredecessorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1222:1: ( ( ( RULE_ID ) ) )
            // InternalPDL1.g:1223:2: ( ( RULE_ID ) )
            {
            // InternalPDL1.g:1223:2: ( ( RULE_ID ) )
            // InternalPDL1.g:1224:3: ( RULE_ID )
            {
             before(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionCrossReference_3_0()); 
            // InternalPDL1.g:1225:3: ( RULE_ID )
            // InternalPDL1.g:1226:4: RULE_ID
            {
             before(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getWorkSequenceAccess().getPredecessorWorkDefinitionCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__PredecessorAssignment_3"


    // $ANTLR start "rule__WorkSequence__SuccessorAssignment_5"
    // InternalPDL1.g:1237:1: rule__WorkSequence__SuccessorAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__WorkSequence__SuccessorAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1241:1: ( ( ( RULE_ID ) ) )
            // InternalPDL1.g:1242:2: ( ( RULE_ID ) )
            {
            // InternalPDL1.g:1242:2: ( ( RULE_ID ) )
            // InternalPDL1.g:1243:3: ( RULE_ID )
            {
             before(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionCrossReference_5_0()); 
            // InternalPDL1.g:1244:3: ( RULE_ID )
            // InternalPDL1.g:1245:4: RULE_ID
            {
             before(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getWorkSequenceAccess().getSuccessorWorkDefinitionCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkSequence__SuccessorAssignment_5"


    // $ANTLR start "rule__Guidance__TexteAssignment_1"
    // InternalPDL1.g:1256:1: rule__Guidance__TexteAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Guidance__TexteAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1260:1: ( ( RULE_STRING ) )
            // InternalPDL1.g:1261:2: ( RULE_STRING )
            {
            // InternalPDL1.g:1261:2: ( RULE_STRING )
            // InternalPDL1.g:1262:3: RULE_STRING
            {
             before(grammarAccess.getGuidanceAccess().getTexteSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getGuidanceAccess().getTexteSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guidance__TexteAssignment_1"


    // $ANTLR start "rule__Resource__NameAssignment_1"
    // InternalPDL1.g:1271:1: rule__Resource__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Resource__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1275:1: ( ( RULE_ID ) )
            // InternalPDL1.g:1276:2: ( RULE_ID )
            {
            // InternalPDL1.g:1276:2: ( RULE_ID )
            // InternalPDL1.g:1277:3: RULE_ID
            {
             before(grammarAccess.getResourceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getResourceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resource__NameAssignment_1"


    // $ANTLR start "rule__Resource__QuantityAssignment_2"
    // InternalPDL1.g:1286:1: rule__Resource__QuantityAssignment_2 : ( RULE_INT ) ;
    public final void rule__Resource__QuantityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1290:1: ( ( RULE_INT ) )
            // InternalPDL1.g:1291:2: ( RULE_INT )
            {
            // InternalPDL1.g:1291:2: ( RULE_INT )
            // InternalPDL1.g:1292:3: RULE_INT
            {
             before(grammarAccess.getResourceAccess().getQuantityINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getResourceAccess().getQuantityINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resource__QuantityAssignment_2"


    // $ANTLR start "rule__Resource__DescriptionAssignment_3"
    // InternalPDL1.g:1301:1: rule__Resource__DescriptionAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Resource__DescriptionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1305:1: ( ( RULE_STRING ) )
            // InternalPDL1.g:1306:2: ( RULE_STRING )
            {
            // InternalPDL1.g:1306:2: ( RULE_STRING )
            // InternalPDL1.g:1307:3: RULE_STRING
            {
             before(grammarAccess.getResourceAccess().getDescriptionSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getResourceAccess().getDescriptionSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resource__DescriptionAssignment_3"


    // $ANTLR start "rule__UsageResource__ResourceAssignment_1"
    // InternalPDL1.g:1316:1: rule__UsageResource__ResourceAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__UsageResource__ResourceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1320:1: ( ( ( RULE_ID ) ) )
            // InternalPDL1.g:1321:2: ( ( RULE_ID ) )
            {
            // InternalPDL1.g:1321:2: ( ( RULE_ID ) )
            // InternalPDL1.g:1322:3: ( RULE_ID )
            {
             before(grammarAccess.getUsageResourceAccess().getResourceResourceCrossReference_1_0()); 
            // InternalPDL1.g:1323:3: ( RULE_ID )
            // InternalPDL1.g:1324:4: RULE_ID
            {
             before(grammarAccess.getUsageResourceAccess().getResourceResourceIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getUsageResourceAccess().getResourceResourceIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getUsageResourceAccess().getResourceResourceCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UsageResource__ResourceAssignment_1"


    // $ANTLR start "rule__UsageResource__UsageQuantityAssignment_2"
    // InternalPDL1.g:1335:1: rule__UsageResource__UsageQuantityAssignment_2 : ( RULE_INT ) ;
    public final void rule__UsageResource__UsageQuantityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1339:1: ( ( RULE_INT ) )
            // InternalPDL1.g:1340:2: ( RULE_INT )
            {
            // InternalPDL1.g:1340:2: ( RULE_INT )
            // InternalPDL1.g:1341:3: RULE_INT
            {
             before(grammarAccess.getUsageResourceAccess().getUsageQuantityINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getUsageResourceAccess().getUsageQuantityINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UsageResource__UsageQuantityAssignment_2"


    // $ANTLR start "rule__UsageResource__UsageTimeAssignment_3"
    // InternalPDL1.g:1350:1: rule__UsageResource__UsageTimeAssignment_3 : ( RULE_INT ) ;
    public final void rule__UsageResource__UsageTimeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPDL1.g:1354:1: ( ( RULE_INT ) )
            // InternalPDL1.g:1355:2: ( RULE_INT )
            {
            // InternalPDL1.g:1355:2: ( RULE_INT )
            // InternalPDL1.g:1356:3: RULE_INT
            {
             before(grammarAccess.getUsageResourceAccess().getUsageTimeINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getUsageResourceAccess().getUsageTimeINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UsageResource__UsageTimeAssignment_3"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000003260000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000001240002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000040L});

}