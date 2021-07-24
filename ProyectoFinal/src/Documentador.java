import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public  class Documentador implements MySqlParserListener {
    public ParseTreeWalker walker = new ParseTreeWalker();
    @Override
    public void enterRoot(MySqlParser.RootContext ctx) {
        System.out.println("***********DOCUMENTACIÓN************");
    }

    @Override
    public void exitRoot(MySqlParser.RootContext ctx) {
        System.out.println("documentacion hecha por.....");
    }

    @Override
    public void enterSqlStatements(MySqlParser.SqlStatementsContext ctx) {

    }

    @Override
    public void exitSqlStatements(MySqlParser.SqlStatementsContext ctx) {

    }

    @Override
    public void enterSqlStatement(MySqlParser.SqlStatementContext ctx) {
        /*int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a,b);
        String viewSql = ctx.start.getInputStream().getText(interval);
        System.out.print("["+viewSql+"]--->");*/
    }

    @Override
    public void exitSqlStatement(MySqlParser.SqlStatementContext ctx) {
        System.out.println();
    }

    @Override
    public void enterEmptyStatement(MySqlParser.EmptyStatementContext ctx) {

    }

    @Override
    public void exitEmptyStatement(MySqlParser.EmptyStatementContext ctx) {

    }

    @Override
    public void enterDdlStatement(MySqlParser.DdlStatementContext ctx) {

    }

    @Override
    public void exitDdlStatement(MySqlParser.DdlStatementContext ctx) {

    }

    @Override
    public void enterDmlStatement(MySqlParser.DmlStatementContext ctx) {

    }

    @Override
    public void exitDmlStatement(MySqlParser.DmlStatementContext ctx) {

    }

    @Override
    public void enterTransactionStatement(MySqlParser.TransactionStatementContext ctx) {

    }

    @Override
    public void exitTransactionStatement(MySqlParser.TransactionStatementContext ctx) {

    }

    @Override
    public void enterReplicationStatement(MySqlParser.ReplicationStatementContext ctx) {

    }

    @Override
    public void exitReplicationStatement(MySqlParser.ReplicationStatementContext ctx) {

    }

    @Override
    public void enterPreparedStatement(MySqlParser.PreparedStatementContext ctx) {

    }

    @Override
    public void exitPreparedStatement(MySqlParser.PreparedStatementContext ctx) {

    }

    @Override
    public void enterCompoundStatement(MySqlParser.CompoundStatementContext ctx) {

    }

    @Override
    public void exitCompoundStatement(MySqlParser.CompoundStatementContext ctx) {

    }

    @Override
    public void enterAdministrationStatement(MySqlParser.AdministrationStatementContext ctx) {

    }

    @Override
    public void exitAdministrationStatement(MySqlParser.AdministrationStatementContext ctx) {

    }

    @Override
    public void enterUtilityStatement(MySqlParser.UtilityStatementContext ctx) {

    }

    @Override
    public void exitUtilityStatement(MySqlParser.UtilityStatementContext ctx) {

    }

    @Override
    public void enterCreateDatabase(MySqlParser.CreateDatabaseContext ctx) {
        System.out.print("SE CREA LA BASE DE DATOS CON NOMBRE:");
        if(ctx.ifNotExists()!=null){
            walker.walk(new Documentador(), ctx.ifNotExists());
        }
        walker.walk(new Documentador(), ctx.uid());
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitCreateDatabase(MySqlParser.CreateDatabaseContext ctx) {

    }

    @Override
    public void enterCreateEvent(MySqlParser.CreateEventContext ctx) {

    }

    @Override
    public void exitCreateEvent(MySqlParser.CreateEventContext ctx) {

    }

    @Override
    public void enterCreateIndex(MySqlParser.CreateIndexContext ctx) {
        System.out.print("SE AÑADE EL INDICE: ");
        if(!ctx.getChild(1).getText().equals("INDEX")){
            System.out.print("(de tipo "+ctx.getChild(1).getText()+") ");
        }
        walker.walk(new Documentador(), ctx.uid());
        System.out.print(",A LA TABLA: ");
        walker.walk(new Documentador(), ctx.tableName());
        System.out.print(",EN :");
        System.out.print(ctx.indexColumnNames().getText());
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitCreateIndex(MySqlParser.CreateIndexContext ctx) {
        System.out.println();
    }

    @Override
    public void enterCreateLogfileGroup(MySqlParser.CreateLogfileGroupContext ctx) {

    }

    @Override
    public void exitCreateLogfileGroup(MySqlParser.CreateLogfileGroupContext ctx) {

    }

    @Override
    public void enterCreateProcedure(MySqlParser.CreateProcedureContext ctx) {
        /*System.out.print("SE CREAL EL PROCESO: ");
        walker.walk(new Documentador(), ctx.fullId());
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }*/

    }

    @Override
    public void exitCreateProcedure(MySqlParser.CreateProcedureContext ctx) {

    }

    @Override
    public void enterCreateFunction(MySqlParser.CreateFunctionContext ctx) {

    }

    @Override
    public void exitCreateFunction(MySqlParser.CreateFunctionContext ctx) {

    }

    @Override
    public void enterCreateServer(MySqlParser.CreateServerContext ctx) {
        System.out.print("SE CREA EL SERVIDOR CON NOMBRE: ");
        walker.walk(new Documentador(), ctx.uid());
        System.out.print(",CON IDENTIFICADOR: ");
        System.out.print(ctx.getChild(6).getText()) ;
        System.out.print(",OPCIONES:( ");
        for(int j =0;j<ctx.serverOption().size();j++) {
            walker.walk(new Documentador(), ctx.serverOption(j));
            if(j<ctx.serverOption().size()-1){
                System.out.print(",");
            }
        }
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitCreateServer(MySqlParser.CreateServerContext ctx) {
        System.out.print(")");
    }

    @Override
    public void enterCopyCreateTable(MySqlParser.CopyCreateTableContext ctx) {

    }

    @Override
    public void exitCopyCreateTable(MySqlParser.CopyCreateTableContext ctx) {

    }

    @Override
    public void enterQueryCreateTable(MySqlParser.QueryCreateTableContext ctx) {

    }

    @Override
    public void exitQueryCreateTable(MySqlParser.QueryCreateTableContext ctx) {

    }

    @Override
    public void enterColumnCreateTable(MySqlParser.ColumnCreateTableContext ctx) {
        System.out.print("SE CREA LA TABLA CON NOMBRE: ");
        walker.walk(new Documentador(), ctx.getChild(2));
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitColumnCreateTable(MySqlParser.ColumnCreateTableContext ctx) {
        System.out.println();
    }

    @Override
    public void enterCreateTablespaceInnodb(MySqlParser.CreateTablespaceInnodbContext ctx) {

    }

    @Override
    public void exitCreateTablespaceInnodb(MySqlParser.CreateTablespaceInnodbContext ctx) {

    }

    @Override
    public void enterCreateTablespaceNdb(MySqlParser.CreateTablespaceNdbContext ctx) {

    }

    @Override
    public void exitCreateTablespaceNdb(MySqlParser.CreateTablespaceNdbContext ctx) {

    }

    @Override
    public void enterCreateTrigger(MySqlParser.CreateTriggerContext ctx) {
        System.out.print("SE CREA EL DISPARADOR CON NOMBRE: ");
        walker.walk(new Documentador(), ctx.fullId(0));
        //------TRIGGER TIME------
        if(ctx.getChild(3).toString().equals("BEFORE")){
            System.out.print("(se activa antes ");
        }else {System.out.print("(se activa despues ");}
        //-----TRIGGER EVENT--------
        if(ctx.getChild(4).toString().equals("INSERT")){
            System.out.print("de insertar)");
        }else if (ctx.getChild(4).toString().equals("UPDATE")){
            System.out.print("de actualizar)");
        }else{System.out.print("de borrar)"); }
        //-----------------------
        System.out.print(",EN LA TABLA: ");
        walker.walk(new Documentador(), ctx.tableName());

        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitCreateTrigger(MySqlParser.CreateTriggerContext ctx) {

    }

    @Override
    public void enterCreateView(MySqlParser.CreateViewContext ctx) {
        System.out.print("CREA LA VISTA CON NOMBRE: ");
        walker.walk(new Documentador(), ctx.fullId());
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitCreateView(MySqlParser.CreateViewContext ctx) {

    }

    @Override
    public void enterCreateDatabaseOption(MySqlParser.CreateDatabaseOptionContext ctx) {

    }

    @Override
    public void exitCreateDatabaseOption(MySqlParser.CreateDatabaseOptionContext ctx) {

    }

    @Override
    public void enterOwnerStatement(MySqlParser.OwnerStatementContext ctx) {

    }

    @Override
    public void exitOwnerStatement(MySqlParser.OwnerStatementContext ctx) {

    }

    @Override
    public void enterPreciseSchedule(MySqlParser.PreciseScheduleContext ctx) {

    }

    @Override
    public void exitPreciseSchedule(MySqlParser.PreciseScheduleContext ctx) {

    }

    @Override
    public void enterIntervalSchedule(MySqlParser.IntervalScheduleContext ctx) {

    }

    @Override
    public void exitIntervalSchedule(MySqlParser.IntervalScheduleContext ctx) {

    }

    @Override
    public void enterTimestampValue(MySqlParser.TimestampValueContext ctx) {

    }

    @Override
    public void exitTimestampValue(MySqlParser.TimestampValueContext ctx) {

    }

    @Override
    public void enterIntervalExpr(MySqlParser.IntervalExprContext ctx) {

    }

    @Override
    public void exitIntervalExpr(MySqlParser.IntervalExprContext ctx) {

    }

    @Override
    public void enterIntervalType(MySqlParser.IntervalTypeContext ctx) {

    }

    @Override
    public void exitIntervalType(MySqlParser.IntervalTypeContext ctx) {

    }

    @Override
    public void enterEnableType(MySqlParser.EnableTypeContext ctx) {

    }

    @Override
    public void exitEnableType(MySqlParser.EnableTypeContext ctx) {

    }

    @Override
    public void enterIndexType(MySqlParser.IndexTypeContext ctx) {

    }

    @Override
    public void exitIndexType(MySqlParser.IndexTypeContext ctx) {

    }

    @Override
    public void enterIndexOption(MySqlParser.IndexOptionContext ctx) {

    }

    @Override
    public void exitIndexOption(MySqlParser.IndexOptionContext ctx) {

    }

    @Override
    public void enterProcedureParameter(MySqlParser.ProcedureParameterContext ctx) {

    }

    @Override
    public void exitProcedureParameter(MySqlParser.ProcedureParameterContext ctx) {

    }

    @Override
    public void enterFunctionParameter(MySqlParser.FunctionParameterContext ctx) {

    }

    @Override
    public void exitFunctionParameter(MySqlParser.FunctionParameterContext ctx) {

    }

    @Override
    public void enterRoutineComment(MySqlParser.RoutineCommentContext ctx) {

    }

    @Override
    public void exitRoutineComment(MySqlParser.RoutineCommentContext ctx) {

    }

    @Override
    public void enterRoutineLanguage(MySqlParser.RoutineLanguageContext ctx) {

    }

    @Override
    public void exitRoutineLanguage(MySqlParser.RoutineLanguageContext ctx) {

    }

    @Override
    public void enterRoutineBehavior(MySqlParser.RoutineBehaviorContext ctx) {

    }

    @Override
    public void exitRoutineBehavior(MySqlParser.RoutineBehaviorContext ctx) {

    }

    @Override
    public void enterRoutineData(MySqlParser.RoutineDataContext ctx) {

    }

    @Override
    public void exitRoutineData(MySqlParser.RoutineDataContext ctx) {

    }

    @Override
    public void enterRoutineSecurity(MySqlParser.RoutineSecurityContext ctx) {

    }

    @Override
    public void exitRoutineSecurity(MySqlParser.RoutineSecurityContext ctx) {

    }

    @Override
    public void enterServerOption(MySqlParser.ServerOptionContext ctx) {
        switch (ctx.getChild(0).toString()) {
            case "HOST":
                System.out.print("host: " + ctx.getChild(1).toString());
                break;
            case "DATABASE":
                System.out.print("database: " + ctx.getChild(1).toString());
                break;
            case "USER":
                System.out.print("user: " + ctx.getChild(1).toString());
                break;
            case "SOCKET":
                System.out.print("socket: " + ctx.getChild(1).toString());
                break;
            case "OWNER":
                System.out.print("owner: " + ctx.getChild(1).toString());
                break;
            case "PORT":
                System.out.print("port: " + ctx.getChild(1).toString());
                break;
        }
    }

    @Override
    public void exitServerOption(MySqlParser.ServerOptionContext ctx) {

    }

    @Override
    public void enterCreateDefinitions(MySqlParser.CreateDefinitionsContext ctx) {

    }

    @Override
    public void exitCreateDefinitions(MySqlParser.CreateDefinitionsContext ctx) {

    }

    @Override
    public void enterColumnDeclaration(MySqlParser.ColumnDeclarationContext ctx) {

    }

    @Override
    public void exitColumnDeclaration(MySqlParser.ColumnDeclarationContext ctx) {

    }

    @Override
    public void enterConstraintDeclaration(MySqlParser.ConstraintDeclarationContext ctx) {

    }

    @Override
    public void exitConstraintDeclaration(MySqlParser.ConstraintDeclarationContext ctx) {

    }

    @Override
    public void enterIndexDeclaration(MySqlParser.IndexDeclarationContext ctx) {

    }

    @Override
    public void exitIndexDeclaration(MySqlParser.IndexDeclarationContext ctx) {

    }

    @Override
    public void enterColumnDefinition(MySqlParser.ColumnDefinitionContext ctx) {

    }

    @Override
    public void exitColumnDefinition(MySqlParser.ColumnDefinitionContext ctx) {

    }

    @Override
    public void enterNullColumnConstraint(MySqlParser.NullColumnConstraintContext ctx) {

    }

    @Override
    public void exitNullColumnConstraint(MySqlParser.NullColumnConstraintContext ctx) {

    }

    @Override
    public void enterDefaultColumnConstraint(MySqlParser.DefaultColumnConstraintContext ctx) {

    }

    @Override
    public void exitDefaultColumnConstraint(MySqlParser.DefaultColumnConstraintContext ctx) {

    }

    @Override
    public void enterVisibilityColumnConstraint(MySqlParser.VisibilityColumnConstraintContext ctx) {

    }

    @Override
    public void exitVisibilityColumnConstraint(MySqlParser.VisibilityColumnConstraintContext ctx) {

    }

    @Override
    public void enterAutoIncrementColumnConstraint(MySqlParser.AutoIncrementColumnConstraintContext ctx) {

    }

    @Override
    public void exitAutoIncrementColumnConstraint(MySqlParser.AutoIncrementColumnConstraintContext ctx) {

    }

    @Override
    public void enterPrimaryKeyColumnConstraint(MySqlParser.PrimaryKeyColumnConstraintContext ctx) {

    }

    @Override
    public void exitPrimaryKeyColumnConstraint(MySqlParser.PrimaryKeyColumnConstraintContext ctx) {

    }

    @Override
    public void enterUniqueKeyColumnConstraint(MySqlParser.UniqueKeyColumnConstraintContext ctx) {

    }

    @Override
    public void exitUniqueKeyColumnConstraint(MySqlParser.UniqueKeyColumnConstraintContext ctx) {

    }

    @Override
    public void enterCommentColumnConstraint(MySqlParser.CommentColumnConstraintContext ctx) {

    }

    @Override
    public void exitCommentColumnConstraint(MySqlParser.CommentColumnConstraintContext ctx) {

    }

    @Override
    public void enterFormatColumnConstraint(MySqlParser.FormatColumnConstraintContext ctx) {

    }

    @Override
    public void exitFormatColumnConstraint(MySqlParser.FormatColumnConstraintContext ctx) {

    }

    @Override
    public void enterStorageColumnConstraint(MySqlParser.StorageColumnConstraintContext ctx) {

    }

    @Override
    public void exitStorageColumnConstraint(MySqlParser.StorageColumnConstraintContext ctx) {

    }

    @Override
    public void enterReferenceColumnConstraint(MySqlParser.ReferenceColumnConstraintContext ctx) {

    }

    @Override
    public void exitReferenceColumnConstraint(MySqlParser.ReferenceColumnConstraintContext ctx) {

    }

    @Override
    public void enterCollateColumnConstraint(MySqlParser.CollateColumnConstraintContext ctx) {

    }

    @Override
    public void exitCollateColumnConstraint(MySqlParser.CollateColumnConstraintContext ctx) {

    }

    @Override
    public void enterGeneratedColumnConstraint(MySqlParser.GeneratedColumnConstraintContext ctx) {

    }

    @Override
    public void exitGeneratedColumnConstraint(MySqlParser.GeneratedColumnConstraintContext ctx) {

    }

    @Override
    public void enterSerialDefaultColumnConstraint(MySqlParser.SerialDefaultColumnConstraintContext ctx) {

    }

    @Override
    public void exitSerialDefaultColumnConstraint(MySqlParser.SerialDefaultColumnConstraintContext ctx) {

    }

    @Override
    public void enterCheckColumnConstraint(MySqlParser.CheckColumnConstraintContext ctx) {

    }

    @Override
    public void exitCheckColumnConstraint(MySqlParser.CheckColumnConstraintContext ctx) {

    }

    @Override
    public void enterPrimaryKeyTableConstraint(MySqlParser.PrimaryKeyTableConstraintContext ctx) {

    }

    @Override
    public void exitPrimaryKeyTableConstraint(MySqlParser.PrimaryKeyTableConstraintContext ctx) {

    }

    @Override
    public void enterUniqueKeyTableConstraint(MySqlParser.UniqueKeyTableConstraintContext ctx) {

    }

    @Override
    public void exitUniqueKeyTableConstraint(MySqlParser.UniqueKeyTableConstraintContext ctx) {

    }

    @Override
    public void enterForeignKeyTableConstraint(MySqlParser.ForeignKeyTableConstraintContext ctx) {

    }

    @Override
    public void exitForeignKeyTableConstraint(MySqlParser.ForeignKeyTableConstraintContext ctx) {

    }

    @Override
    public void enterCheckTableConstraint(MySqlParser.CheckTableConstraintContext ctx) {

    }

    @Override
    public void exitCheckTableConstraint(MySqlParser.CheckTableConstraintContext ctx) {

    }

    @Override
    public void enterReferenceDefinition(MySqlParser.ReferenceDefinitionContext ctx) {

    }

    @Override
    public void exitReferenceDefinition(MySqlParser.ReferenceDefinitionContext ctx) {

    }

    @Override
    public void enterReferenceAction(MySqlParser.ReferenceActionContext ctx) {

    }

    @Override
    public void exitReferenceAction(MySqlParser.ReferenceActionContext ctx) {

    }

    @Override
    public void enterReferenceControlType(MySqlParser.ReferenceControlTypeContext ctx) {

    }

    @Override
    public void exitReferenceControlType(MySqlParser.ReferenceControlTypeContext ctx) {

    }

    @Override
    public void enterSimpleIndexDeclaration(MySqlParser.SimpleIndexDeclarationContext ctx) {

    }

    @Override
    public void exitSimpleIndexDeclaration(MySqlParser.SimpleIndexDeclarationContext ctx) {

    }

    @Override
    public void enterSpecialIndexDeclaration(MySqlParser.SpecialIndexDeclarationContext ctx) {

    }

    @Override
    public void exitSpecialIndexDeclaration(MySqlParser.SpecialIndexDeclarationContext ctx) {

    }

    @Override
    public void enterTableOptionEngine(MySqlParser.TableOptionEngineContext ctx) {

    }

    @Override
    public void exitTableOptionEngine(MySqlParser.TableOptionEngineContext ctx) {

    }

    @Override
    public void enterTableOptionAutoIncrement(MySqlParser.TableOptionAutoIncrementContext ctx) {

    }

    @Override
    public void exitTableOptionAutoIncrement(MySqlParser.TableOptionAutoIncrementContext ctx) {

    }

    @Override
    public void enterTableOptionAverage(MySqlParser.TableOptionAverageContext ctx) {

    }

    @Override
    public void exitTableOptionAverage(MySqlParser.TableOptionAverageContext ctx) {

    }

    @Override
    public void enterTableOptionCharset(MySqlParser.TableOptionCharsetContext ctx) {

    }

    @Override
    public void exitTableOptionCharset(MySqlParser.TableOptionCharsetContext ctx) {

    }

    @Override
    public void enterTableOptionChecksum(MySqlParser.TableOptionChecksumContext ctx) {

    }

    @Override
    public void exitTableOptionChecksum(MySqlParser.TableOptionChecksumContext ctx) {

    }

    @Override
    public void enterTableOptionCollate(MySqlParser.TableOptionCollateContext ctx) {

    }

    @Override
    public void exitTableOptionCollate(MySqlParser.TableOptionCollateContext ctx) {

    }

    @Override
    public void enterTableOptionComment(MySqlParser.TableOptionCommentContext ctx) {

    }

    @Override
    public void exitTableOptionComment(MySqlParser.TableOptionCommentContext ctx) {

    }

    @Override
    public void enterTableOptionCompression(MySqlParser.TableOptionCompressionContext ctx) {

    }

    @Override
    public void exitTableOptionCompression(MySqlParser.TableOptionCompressionContext ctx) {

    }

    @Override
    public void enterTableOptionConnection(MySqlParser.TableOptionConnectionContext ctx) {

    }

    @Override
    public void exitTableOptionConnection(MySqlParser.TableOptionConnectionContext ctx) {

    }

    @Override
    public void enterTableOptionDataDirectory(MySqlParser.TableOptionDataDirectoryContext ctx) {

    }

    @Override
    public void exitTableOptionDataDirectory(MySqlParser.TableOptionDataDirectoryContext ctx) {

    }

    @Override
    public void enterTableOptionDelay(MySqlParser.TableOptionDelayContext ctx) {

    }

    @Override
    public void exitTableOptionDelay(MySqlParser.TableOptionDelayContext ctx) {

    }

    @Override
    public void enterTableOptionEncryption(MySqlParser.TableOptionEncryptionContext ctx) {

    }

    @Override
    public void exitTableOptionEncryption(MySqlParser.TableOptionEncryptionContext ctx) {

    }

    @Override
    public void enterTableOptionIndexDirectory(MySqlParser.TableOptionIndexDirectoryContext ctx) {

    }

    @Override
    public void exitTableOptionIndexDirectory(MySqlParser.TableOptionIndexDirectoryContext ctx) {

    }

    @Override
    public void enterTableOptionInsertMethod(MySqlParser.TableOptionInsertMethodContext ctx) {

    }

    @Override
    public void exitTableOptionInsertMethod(MySqlParser.TableOptionInsertMethodContext ctx) {

    }

    @Override
    public void enterTableOptionKeyBlockSize(MySqlParser.TableOptionKeyBlockSizeContext ctx) {

    }

    @Override
    public void exitTableOptionKeyBlockSize(MySqlParser.TableOptionKeyBlockSizeContext ctx) {

    }

    @Override
    public void enterTableOptionMaxRows(MySqlParser.TableOptionMaxRowsContext ctx) {

    }

    @Override
    public void exitTableOptionMaxRows(MySqlParser.TableOptionMaxRowsContext ctx) {

    }

    @Override
    public void enterTableOptionMinRows(MySqlParser.TableOptionMinRowsContext ctx) {

    }

    @Override
    public void exitTableOptionMinRows(MySqlParser.TableOptionMinRowsContext ctx) {

    }

    @Override
    public void enterTableOptionPackKeys(MySqlParser.TableOptionPackKeysContext ctx) {

    }

    @Override
    public void exitTableOptionPackKeys(MySqlParser.TableOptionPackKeysContext ctx) {

    }

    @Override
    public void enterTableOptionPassword(MySqlParser.TableOptionPasswordContext ctx) {

    }

    @Override
    public void exitTableOptionPassword(MySqlParser.TableOptionPasswordContext ctx) {

    }

    @Override
    public void enterTableOptionRowFormat(MySqlParser.TableOptionRowFormatContext ctx) {

    }

    @Override
    public void exitTableOptionRowFormat(MySqlParser.TableOptionRowFormatContext ctx) {

    }

    @Override
    public void enterTableOptionRecalculation(MySqlParser.TableOptionRecalculationContext ctx) {

    }

    @Override
    public void exitTableOptionRecalculation(MySqlParser.TableOptionRecalculationContext ctx) {

    }

    @Override
    public void enterTableOptionPersistent(MySqlParser.TableOptionPersistentContext ctx) {

    }

    @Override
    public void exitTableOptionPersistent(MySqlParser.TableOptionPersistentContext ctx) {

    }

    @Override
    public void enterTableOptionSamplePage(MySqlParser.TableOptionSamplePageContext ctx) {

    }

    @Override
    public void exitTableOptionSamplePage(MySqlParser.TableOptionSamplePageContext ctx) {

    }

    @Override
    public void enterTableOptionTablespace(MySqlParser.TableOptionTablespaceContext ctx) {

    }

    @Override
    public void exitTableOptionTablespace(MySqlParser.TableOptionTablespaceContext ctx) {

    }

    @Override
    public void enterTableOptionTableType(MySqlParser.TableOptionTableTypeContext ctx) {

    }

    @Override
    public void exitTableOptionTableType(MySqlParser.TableOptionTableTypeContext ctx) {

    }

    @Override
    public void enterTableOptionUnion(MySqlParser.TableOptionUnionContext ctx) {

    }

    @Override
    public void exitTableOptionUnion(MySqlParser.TableOptionUnionContext ctx) {

    }

    @Override
    public void enterTableType(MySqlParser.TableTypeContext ctx) {

    }

    @Override
    public void exitTableType(MySqlParser.TableTypeContext ctx) {

    }

    @Override
    public void enterTablespaceStorage(MySqlParser.TablespaceStorageContext ctx) {

    }

    @Override
    public void exitTablespaceStorage(MySqlParser.TablespaceStorageContext ctx) {

    }

    @Override
    public void enterPartitionDefinitions(MySqlParser.PartitionDefinitionsContext ctx) {

    }

    @Override
    public void exitPartitionDefinitions(MySqlParser.PartitionDefinitionsContext ctx) {

    }

    @Override
    public void enterPartitionFunctionHash(MySqlParser.PartitionFunctionHashContext ctx) {

    }

    @Override
    public void exitPartitionFunctionHash(MySqlParser.PartitionFunctionHashContext ctx) {

    }

    @Override
    public void enterPartitionFunctionKey(MySqlParser.PartitionFunctionKeyContext ctx) {

    }

    @Override
    public void exitPartitionFunctionKey(MySqlParser.PartitionFunctionKeyContext ctx) {

    }

    @Override
    public void enterPartitionFunctionRange(MySqlParser.PartitionFunctionRangeContext ctx) {

    }

    @Override
    public void exitPartitionFunctionRange(MySqlParser.PartitionFunctionRangeContext ctx) {

    }

    @Override
    public void enterPartitionFunctionList(MySqlParser.PartitionFunctionListContext ctx) {

    }

    @Override
    public void exitPartitionFunctionList(MySqlParser.PartitionFunctionListContext ctx) {

    }

    @Override
    public void enterSubPartitionFunctionHash(MySqlParser.SubPartitionFunctionHashContext ctx) {

    }

    @Override
    public void exitSubPartitionFunctionHash(MySqlParser.SubPartitionFunctionHashContext ctx) {

    }

    @Override
    public void enterSubPartitionFunctionKey(MySqlParser.SubPartitionFunctionKeyContext ctx) {

    }

    @Override
    public void exitSubPartitionFunctionKey(MySqlParser.SubPartitionFunctionKeyContext ctx) {

    }

    @Override
    public void enterPartitionComparison(MySqlParser.PartitionComparisonContext ctx) {

    }

    @Override
    public void exitPartitionComparison(MySqlParser.PartitionComparisonContext ctx) {

    }

    @Override
    public void enterPartitionListAtom(MySqlParser.PartitionListAtomContext ctx) {

    }

    @Override
    public void exitPartitionListAtom(MySqlParser.PartitionListAtomContext ctx) {

    }

    @Override
    public void enterPartitionListVector(MySqlParser.PartitionListVectorContext ctx) {

    }

    @Override
    public void exitPartitionListVector(MySqlParser.PartitionListVectorContext ctx) {

    }

    @Override
    public void enterPartitionSimple(MySqlParser.PartitionSimpleContext ctx) {

    }

    @Override
    public void exitPartitionSimple(MySqlParser.PartitionSimpleContext ctx) {

    }

    @Override
    public void enterPartitionDefinerAtom(MySqlParser.PartitionDefinerAtomContext ctx) {

    }

    @Override
    public void exitPartitionDefinerAtom(MySqlParser.PartitionDefinerAtomContext ctx) {

    }

    @Override
    public void enterPartitionDefinerVector(MySqlParser.PartitionDefinerVectorContext ctx) {

    }

    @Override
    public void exitPartitionDefinerVector(MySqlParser.PartitionDefinerVectorContext ctx) {

    }

    @Override
    public void enterSubpartitionDefinition(MySqlParser.SubpartitionDefinitionContext ctx) {

    }

    @Override
    public void exitSubpartitionDefinition(MySqlParser.SubpartitionDefinitionContext ctx) {

    }

    @Override
    public void enterPartitionOptionEngine(MySqlParser.PartitionOptionEngineContext ctx) {

    }

    @Override
    public void exitPartitionOptionEngine(MySqlParser.PartitionOptionEngineContext ctx) {

    }

    @Override
    public void enterPartitionOptionComment(MySqlParser.PartitionOptionCommentContext ctx) {

    }

    @Override
    public void exitPartitionOptionComment(MySqlParser.PartitionOptionCommentContext ctx) {

    }

    @Override
    public void enterPartitionOptionDataDirectory(MySqlParser.PartitionOptionDataDirectoryContext ctx) {

    }

    @Override
    public void exitPartitionOptionDataDirectory(MySqlParser.PartitionOptionDataDirectoryContext ctx) {

    }

    @Override
    public void enterPartitionOptionIndexDirectory(MySqlParser.PartitionOptionIndexDirectoryContext ctx) {

    }

    @Override
    public void exitPartitionOptionIndexDirectory(MySqlParser.PartitionOptionIndexDirectoryContext ctx) {

    }

    @Override
    public void enterPartitionOptionMaxRows(MySqlParser.PartitionOptionMaxRowsContext ctx) {

    }

    @Override
    public void exitPartitionOptionMaxRows(MySqlParser.PartitionOptionMaxRowsContext ctx) {

    }

    @Override
    public void enterPartitionOptionMinRows(MySqlParser.PartitionOptionMinRowsContext ctx) {

    }

    @Override
    public void exitPartitionOptionMinRows(MySqlParser.PartitionOptionMinRowsContext ctx) {

    }

    @Override
    public void enterPartitionOptionTablespace(MySqlParser.PartitionOptionTablespaceContext ctx) {

    }

    @Override
    public void exitPartitionOptionTablespace(MySqlParser.PartitionOptionTablespaceContext ctx) {

    }

    @Override
    public void enterPartitionOptionNodeGroup(MySqlParser.PartitionOptionNodeGroupContext ctx) {

    }

    @Override
    public void exitPartitionOptionNodeGroup(MySqlParser.PartitionOptionNodeGroupContext ctx) {

    }

    @Override
    public void enterAlterSimpleDatabase(MySqlParser.AlterSimpleDatabaseContext ctx) {
        System.out.print("SE ALTERA LA BASE DE DATOS CON NOMBRE:");
        walker.walk(new Documentador(), ctx.getChild(2));
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitAlterSimpleDatabase(MySqlParser.AlterSimpleDatabaseContext ctx) {

    }

    @Override
    public void enterAlterUpgradeName(MySqlParser.AlterUpgradeNameContext ctx) {

    }

    @Override
    public void exitAlterUpgradeName(MySqlParser.AlterUpgradeNameContext ctx) {

    }

    @Override
    public void enterAlterEvent(MySqlParser.AlterEventContext ctx) {

    }

    @Override
    public void exitAlterEvent(MySqlParser.AlterEventContext ctx) {

    }

    @Override
    public void enterAlterFunction(MySqlParser.AlterFunctionContext ctx) {

    }

    @Override
    public void exitAlterFunction(MySqlParser.AlterFunctionContext ctx) {

    }

    @Override
    public void enterAlterInstance(MySqlParser.AlterInstanceContext ctx) {

    }

    @Override
    public void exitAlterInstance(MySqlParser.AlterInstanceContext ctx) {

    }

    @Override
    public void enterAlterLogfileGroup(MySqlParser.AlterLogfileGroupContext ctx) {

    }

    @Override
    public void exitAlterLogfileGroup(MySqlParser.AlterLogfileGroupContext ctx) {

    }

    @Override
    public void enterAlterProcedure(MySqlParser.AlterProcedureContext ctx) {

    }

    @Override
    public void exitAlterProcedure(MySqlParser.AlterProcedureContext ctx) {

    }

    @Override
    public void enterAlterServer(MySqlParser.AlterServerContext ctx) {
        System.out.print("SE ALTERA EL SERVIDOR CON NOMBRE:");
        walker.walk(new Documentador(), ctx.getChild(2));
        System.out.print(",OPCIONES:( ");
        for(int j =0;j<ctx.serverOption().size();j++) {
            walker.walk(new Documentador(), ctx.serverOption(j));
            if(j<ctx.serverOption().size()-1){
                System.out.print(",");
            }
        }
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitAlterServer(MySqlParser.AlterServerContext ctx) {
        System.out.print(")");
    }

    @Override
    public void enterAlterTable(MySqlParser.AlterTableContext ctx) {

    }

    @Override
    public void exitAlterTable(MySqlParser.AlterTableContext ctx) {

    }

    @Override
    public void enterAlterTablespace(MySqlParser.AlterTablespaceContext ctx) {

    }

    @Override
    public void exitAlterTablespace(MySqlParser.AlterTablespaceContext ctx) {

    }

    @Override
    public void enterAlterView(MySqlParser.AlterViewContext ctx) {

    }

    @Override
    public void exitAlterView(MySqlParser.AlterViewContext ctx) {

    }

    @Override
    public void enterAlterByTableOption(MySqlParser.AlterByTableOptionContext ctx) {

    }

    @Override
    public void exitAlterByTableOption(MySqlParser.AlterByTableOptionContext ctx) {

    }

    @Override
    public void enterAlterByAddColumn(MySqlParser.AlterByAddColumnContext ctx) {

    }

    @Override
    public void exitAlterByAddColumn(MySqlParser.AlterByAddColumnContext ctx) {

    }

    @Override
    public void enterAlterByAddColumns(MySqlParser.AlterByAddColumnsContext ctx) {

    }

    @Override
    public void exitAlterByAddColumns(MySqlParser.AlterByAddColumnsContext ctx) {

    }

    @Override
    public void enterAlterByAddIndex(MySqlParser.AlterByAddIndexContext ctx) {

    }

    @Override
    public void exitAlterByAddIndex(MySqlParser.AlterByAddIndexContext ctx) {

    }

    @Override
    public void enterAlterByAddPrimaryKey(MySqlParser.AlterByAddPrimaryKeyContext ctx) {

    }

    @Override
    public void exitAlterByAddPrimaryKey(MySqlParser.AlterByAddPrimaryKeyContext ctx) {

    }

    @Override
    public void enterAlterByAddUniqueKey(MySqlParser.AlterByAddUniqueKeyContext ctx) {

    }

    @Override
    public void exitAlterByAddUniqueKey(MySqlParser.AlterByAddUniqueKeyContext ctx) {

    }

    @Override
    public void enterAlterByAddSpecialIndex(MySqlParser.AlterByAddSpecialIndexContext ctx) {

    }

    @Override
    public void exitAlterByAddSpecialIndex(MySqlParser.AlterByAddSpecialIndexContext ctx) {

    }

    @Override
    public void enterAlterByAddForeignKey(MySqlParser.AlterByAddForeignKeyContext ctx) {

    }

    @Override
    public void exitAlterByAddForeignKey(MySqlParser.AlterByAddForeignKeyContext ctx) {

    }

    @Override
    public void enterAlterByAddCheckTableConstraint(MySqlParser.AlterByAddCheckTableConstraintContext ctx) {

    }

    @Override
    public void exitAlterByAddCheckTableConstraint(MySqlParser.AlterByAddCheckTableConstraintContext ctx) {

    }

    @Override
    public void enterAlterBySetAlgorithm(MySqlParser.AlterBySetAlgorithmContext ctx) {

    }

    @Override
    public void exitAlterBySetAlgorithm(MySqlParser.AlterBySetAlgorithmContext ctx) {

    }

    @Override
    public void enterAlterByChangeDefault(MySqlParser.AlterByChangeDefaultContext ctx) {

    }

    @Override
    public void exitAlterByChangeDefault(MySqlParser.AlterByChangeDefaultContext ctx) {

    }

    @Override
    public void enterAlterByChangeColumn(MySqlParser.AlterByChangeColumnContext ctx) {

    }

    @Override
    public void exitAlterByChangeColumn(MySqlParser.AlterByChangeColumnContext ctx) {

    }

    @Override
    public void enterAlterByRenameColumn(MySqlParser.AlterByRenameColumnContext ctx) {

    }

    @Override
    public void exitAlterByRenameColumn(MySqlParser.AlterByRenameColumnContext ctx) {

    }

    @Override
    public void enterAlterByLock(MySqlParser.AlterByLockContext ctx) {

    }

    @Override
    public void exitAlterByLock(MySqlParser.AlterByLockContext ctx) {

    }

    @Override
    public void enterAlterByModifyColumn(MySqlParser.AlterByModifyColumnContext ctx) {

    }

    @Override
    public void exitAlterByModifyColumn(MySqlParser.AlterByModifyColumnContext ctx) {

    }

    @Override
    public void enterAlterByDropColumn(MySqlParser.AlterByDropColumnContext ctx) {

    }

    @Override
    public void exitAlterByDropColumn(MySqlParser.AlterByDropColumnContext ctx) {

    }

    @Override
    public void enterAlterByDropConstraintCheck(MySqlParser.AlterByDropConstraintCheckContext ctx) {

    }

    @Override
    public void exitAlterByDropConstraintCheck(MySqlParser.AlterByDropConstraintCheckContext ctx) {

    }

    @Override
    public void enterAlterByDropPrimaryKey(MySqlParser.AlterByDropPrimaryKeyContext ctx) {

    }

    @Override
    public void exitAlterByDropPrimaryKey(MySqlParser.AlterByDropPrimaryKeyContext ctx) {

    }

    @Override
    public void enterAlterByRenameIndex(MySqlParser.AlterByRenameIndexContext ctx) {

    }

    @Override
    public void exitAlterByRenameIndex(MySqlParser.AlterByRenameIndexContext ctx) {

    }

    @Override
    public void enterAlterByAlterIndexVisibility(MySqlParser.AlterByAlterIndexVisibilityContext ctx) {

    }

    @Override
    public void exitAlterByAlterIndexVisibility(MySqlParser.AlterByAlterIndexVisibilityContext ctx) {

    }

    @Override
    public void enterAlterByDropIndex(MySqlParser.AlterByDropIndexContext ctx) {

    }

    @Override
    public void exitAlterByDropIndex(MySqlParser.AlterByDropIndexContext ctx) {

    }

    @Override
    public void enterAlterByDropForeignKey(MySqlParser.AlterByDropForeignKeyContext ctx) {

    }

    @Override
    public void exitAlterByDropForeignKey(MySqlParser.AlterByDropForeignKeyContext ctx) {

    }

    @Override
    public void enterAlterByDisableKeys(MySqlParser.AlterByDisableKeysContext ctx) {

    }

    @Override
    public void exitAlterByDisableKeys(MySqlParser.AlterByDisableKeysContext ctx) {

    }

    @Override
    public void enterAlterByEnableKeys(MySqlParser.AlterByEnableKeysContext ctx) {

    }

    @Override
    public void exitAlterByEnableKeys(MySqlParser.AlterByEnableKeysContext ctx) {

    }

    @Override
    public void enterAlterByRename(MySqlParser.AlterByRenameContext ctx) {

    }

    @Override
    public void exitAlterByRename(MySqlParser.AlterByRenameContext ctx) {

    }

    @Override
    public void enterAlterByOrder(MySqlParser.AlterByOrderContext ctx) {

    }

    @Override
    public void exitAlterByOrder(MySqlParser.AlterByOrderContext ctx) {

    }

    @Override
    public void enterAlterByConvertCharset(MySqlParser.AlterByConvertCharsetContext ctx) {

    }

    @Override
    public void exitAlterByConvertCharset(MySqlParser.AlterByConvertCharsetContext ctx) {

    }

    @Override
    public void enterAlterByDefaultCharset(MySqlParser.AlterByDefaultCharsetContext ctx) {

    }

    @Override
    public void exitAlterByDefaultCharset(MySqlParser.AlterByDefaultCharsetContext ctx) {

    }

    @Override
    public void enterAlterByDiscardTablespace(MySqlParser.AlterByDiscardTablespaceContext ctx) {

    }

    @Override
    public void exitAlterByDiscardTablespace(MySqlParser.AlterByDiscardTablespaceContext ctx) {

    }

    @Override
    public void enterAlterByImportTablespace(MySqlParser.AlterByImportTablespaceContext ctx) {

    }

    @Override
    public void exitAlterByImportTablespace(MySqlParser.AlterByImportTablespaceContext ctx) {

    }

    @Override
    public void enterAlterByForce(MySqlParser.AlterByForceContext ctx) {

    }

    @Override
    public void exitAlterByForce(MySqlParser.AlterByForceContext ctx) {

    }

    @Override
    public void enterAlterByValidate(MySqlParser.AlterByValidateContext ctx) {

    }

    @Override
    public void exitAlterByValidate(MySqlParser.AlterByValidateContext ctx) {

    }

    @Override
    public void enterAlterByAddPartition(MySqlParser.AlterByAddPartitionContext ctx) {

    }

    @Override
    public void exitAlterByAddPartition(MySqlParser.AlterByAddPartitionContext ctx) {

    }

    @Override
    public void enterAlterByDropPartition(MySqlParser.AlterByDropPartitionContext ctx) {

    }

    @Override
    public void exitAlterByDropPartition(MySqlParser.AlterByDropPartitionContext ctx) {

    }

    @Override
    public void enterAlterByDiscardPartition(MySqlParser.AlterByDiscardPartitionContext ctx) {

    }

    @Override
    public void exitAlterByDiscardPartition(MySqlParser.AlterByDiscardPartitionContext ctx) {

    }

    @Override
    public void enterAlterByImportPartition(MySqlParser.AlterByImportPartitionContext ctx) {

    }

    @Override
    public void exitAlterByImportPartition(MySqlParser.AlterByImportPartitionContext ctx) {

    }

    @Override
    public void enterAlterByTruncatePartition(MySqlParser.AlterByTruncatePartitionContext ctx) {

    }

    @Override
    public void exitAlterByTruncatePartition(MySqlParser.AlterByTruncatePartitionContext ctx) {

    }

    @Override
    public void enterAlterByCoalescePartition(MySqlParser.AlterByCoalescePartitionContext ctx) {

    }

    @Override
    public void exitAlterByCoalescePartition(MySqlParser.AlterByCoalescePartitionContext ctx) {

    }

    @Override
    public void enterAlterByReorganizePartition(MySqlParser.AlterByReorganizePartitionContext ctx) {

    }

    @Override
    public void exitAlterByReorganizePartition(MySqlParser.AlterByReorganizePartitionContext ctx) {

    }

    @Override
    public void enterAlterByExchangePartition(MySqlParser.AlterByExchangePartitionContext ctx) {

    }

    @Override
    public void exitAlterByExchangePartition(MySqlParser.AlterByExchangePartitionContext ctx) {

    }

    @Override
    public void enterAlterByAnalyzePartition(MySqlParser.AlterByAnalyzePartitionContext ctx) {

    }

    @Override
    public void exitAlterByAnalyzePartition(MySqlParser.AlterByAnalyzePartitionContext ctx) {

    }

    @Override
    public void enterAlterByCheckPartition(MySqlParser.AlterByCheckPartitionContext ctx) {

    }

    @Override
    public void exitAlterByCheckPartition(MySqlParser.AlterByCheckPartitionContext ctx) {

    }

    @Override
    public void enterAlterByOptimizePartition(MySqlParser.AlterByOptimizePartitionContext ctx) {

    }

    @Override
    public void exitAlterByOptimizePartition(MySqlParser.AlterByOptimizePartitionContext ctx) {

    }

    @Override
    public void enterAlterByRebuildPartition(MySqlParser.AlterByRebuildPartitionContext ctx) {

    }

    @Override
    public void exitAlterByRebuildPartition(MySqlParser.AlterByRebuildPartitionContext ctx) {

    }

    @Override
    public void enterAlterByRepairPartition(MySqlParser.AlterByRepairPartitionContext ctx) {

    }

    @Override
    public void exitAlterByRepairPartition(MySqlParser.AlterByRepairPartitionContext ctx) {

    }

    @Override
    public void enterAlterByRemovePartitioning(MySqlParser.AlterByRemovePartitioningContext ctx) {

    }

    @Override
    public void exitAlterByRemovePartitioning(MySqlParser.AlterByRemovePartitioningContext ctx) {

    }

    @Override
    public void enterAlterByUpgradePartitioning(MySqlParser.AlterByUpgradePartitioningContext ctx) {

    }

    @Override
    public void exitAlterByUpgradePartitioning(MySqlParser.AlterByUpgradePartitioningContext ctx) {

    }

    @Override
    public void enterDropDatabase(MySqlParser.DropDatabaseContext ctx) {
        System.out.print("SE BORRA LA BASE DE DATOS CON NOMBRE:");
        if(ctx.ifExists()!=null){
            walker.walk(new Documentador(), ctx.ifExists());
        }
        walker.walk(new Documentador(), ctx.uid());
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitDropDatabase(MySqlParser.DropDatabaseContext ctx) {

    }

    @Override
    public void enterDropEvent(MySqlParser.DropEventContext ctx) {

    }

    @Override
    public void exitDropEvent(MySqlParser.DropEventContext ctx) {

    }

    @Override
    public void enterDropIndex(MySqlParser.DropIndexContext ctx) {
        System.out.print("SE BORRA EL INDEX CON NOMBRE:");
        walker.walk(new Documentador(), ctx.uid());
        System.out.print(",EN LA TABLA: ");
        walker.walk(new Documentador(), ctx.tableName());
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitDropIndex(MySqlParser.DropIndexContext ctx) {

    }

    @Override
    public void enterDropLogfileGroup(MySqlParser.DropLogfileGroupContext ctx) {

    }

    @Override
    public void exitDropLogfileGroup(MySqlParser.DropLogfileGroupContext ctx) {

    }

    @Override
    public void enterDropProcedure(MySqlParser.DropProcedureContext ctx) {

    }

    @Override
    public void exitDropProcedure(MySqlParser.DropProcedureContext ctx) {

    }

    @Override
    public void enterDropFunction(MySqlParser.DropFunctionContext ctx) {

    }

    @Override
    public void exitDropFunction(MySqlParser.DropFunctionContext ctx) {

    }

    @Override
    public void enterDropServer(MySqlParser.DropServerContext ctx) {
        System.out.print("SE BORRA EL SERVIDOR CON NOMBRE:");
        if(ctx.ifExists()!=null){
            walker.walk(new Documentador(), ctx.ifExists());
        }
        walker.walk(new Documentador(), ctx.uid());
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitDropServer(MySqlParser.DropServerContext ctx) {

    }

    @Override
    public void enterDropTable(MySqlParser.DropTableContext ctx) {

    }

    @Override
    public void exitDropTable(MySqlParser.DropTableContext ctx) {

    }

    @Override
    public void enterDropTablespace(MySqlParser.DropTablespaceContext ctx) {

    }

    @Override
    public void exitDropTablespace(MySqlParser.DropTablespaceContext ctx) {

    }

    @Override
    public void enterDropTrigger(MySqlParser.DropTriggerContext ctx) {
        System.out.print("SE BORRA EL DISPARADOR CON NOMBRE:");
        if(ctx.ifExists()!=null){
            walker.walk(new Documentador(), ctx.ifExists());
        }
        walker.walk(new Documentador(), ctx.fullId());
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitDropTrigger(MySqlParser.DropTriggerContext ctx) {

    }

    @Override
    public void enterDropView(MySqlParser.DropViewContext ctx) {
        System.out.print("SE BORRA(N) LA(S) VISTA(s) CON NOMBRE(S):");
        if(ctx.ifExists()!=null){
            walker.walk(new Documentador(), ctx.ifExists());
        }
        for(int j =0;j<ctx.fullId().size();j++) {
            walker.walk(new Documentador(), ctx.fullId(j));
            if(j<ctx.fullId().size()-1){
                System.out.print(",");
            }
        }
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitDropView(MySqlParser.DropViewContext ctx) {

    }

    @Override
    public void enterRenameTable(MySqlParser.RenameTableContext ctx) {

    }

    @Override
    public void exitRenameTable(MySqlParser.RenameTableContext ctx) {

    }

    @Override
    public void enterRenameTableClause(MySqlParser.RenameTableClauseContext ctx) {

    }

    @Override
    public void exitRenameTableClause(MySqlParser.RenameTableClauseContext ctx) {

    }

    @Override
    public void enterTruncateTable(MySqlParser.TruncateTableContext ctx) {

    }

    @Override
    public void exitTruncateTable(MySqlParser.TruncateTableContext ctx) {

    }

    @Override
    public void enterCallStatement(MySqlParser.CallStatementContext ctx) {

    }

    @Override
    public void exitCallStatement(MySqlParser.CallStatementContext ctx) {

    }

    @Override
    public void enterDeleteStatement(MySqlParser.DeleteStatementContext ctx) {

    }

    @Override
    public void exitDeleteStatement(MySqlParser.DeleteStatementContext ctx) {

    }

    @Override
    public void enterDoStatement(MySqlParser.DoStatementContext ctx) {

    }

    @Override
    public void exitDoStatement(MySqlParser.DoStatementContext ctx) {

    }

    @Override
    public void enterHandlerStatement(MySqlParser.HandlerStatementContext ctx) {

    }

    @Override
    public void exitHandlerStatement(MySqlParser.HandlerStatementContext ctx) {

    }

    @Override
    public void enterInsertStatement(MySqlParser.InsertStatementContext ctx) {

    }

    @Override
    public void exitInsertStatement(MySqlParser.InsertStatementContext ctx) {

    }

    @Override
    public void enterLoadDataStatement(MySqlParser.LoadDataStatementContext ctx) {

    }

    @Override
    public void exitLoadDataStatement(MySqlParser.LoadDataStatementContext ctx) {

    }

    @Override
    public void enterLoadXmlStatement(MySqlParser.LoadXmlStatementContext ctx) {

    }

    @Override
    public void exitLoadXmlStatement(MySqlParser.LoadXmlStatementContext ctx) {

    }

    @Override
    public void enterReplaceStatement(MySqlParser.ReplaceStatementContext ctx) {

    }

    @Override
    public void exitReplaceStatement(MySqlParser.ReplaceStatementContext ctx) {

    }

    @Override
    public void enterSimpleSelect(MySqlParser.SimpleSelectContext ctx) {

    }

    @Override
    public void exitSimpleSelect(MySqlParser.SimpleSelectContext ctx) {

    }

    @Override
    public void enterParenthesisSelect(MySqlParser.ParenthesisSelectContext ctx) {

    }

    @Override
    public void exitParenthesisSelect(MySqlParser.ParenthesisSelectContext ctx) {

    }

    @Override
    public void enterUnionSelect(MySqlParser.UnionSelectContext ctx) {

    }

    @Override
    public void exitUnionSelect(MySqlParser.UnionSelectContext ctx) {

    }

    @Override
    public void enterUnionParenthesisSelect(MySqlParser.UnionParenthesisSelectContext ctx) {

    }

    @Override
    public void exitUnionParenthesisSelect(MySqlParser.UnionParenthesisSelectContext ctx) {

    }

    @Override
    public void enterUpdateStatement(MySqlParser.UpdateStatementContext ctx) {

    }

    @Override
    public void exitUpdateStatement(MySqlParser.UpdateStatementContext ctx) {

    }

    @Override
    public void enterInsertStatementValue(MySqlParser.InsertStatementValueContext ctx) {

    }

    @Override
    public void exitInsertStatementValue(MySqlParser.InsertStatementValueContext ctx) {

    }

    @Override
    public void enterUpdatedElement(MySqlParser.UpdatedElementContext ctx) {

    }

    @Override
    public void exitUpdatedElement(MySqlParser.UpdatedElementContext ctx) {

    }

    @Override
    public void enterAssignmentField(MySqlParser.AssignmentFieldContext ctx) {

    }

    @Override
    public void exitAssignmentField(MySqlParser.AssignmentFieldContext ctx) {

    }

    @Override
    public void enterLockClause(MySqlParser.LockClauseContext ctx) {

    }

    @Override
    public void exitLockClause(MySqlParser.LockClauseContext ctx) {

    }

    @Override
    public void enterSingleDeleteStatement(MySqlParser.SingleDeleteStatementContext ctx) {

    }

    @Override
    public void exitSingleDeleteStatement(MySqlParser.SingleDeleteStatementContext ctx) {

    }

    @Override
    public void enterMultipleDeleteStatement(MySqlParser.MultipleDeleteStatementContext ctx) {

    }

    @Override
    public void exitMultipleDeleteStatement(MySqlParser.MultipleDeleteStatementContext ctx) {

    }

    @Override
    public void enterHandlerOpenStatement(MySqlParser.HandlerOpenStatementContext ctx) {

    }

    @Override
    public void exitHandlerOpenStatement(MySqlParser.HandlerOpenStatementContext ctx) {

    }

    @Override
    public void enterHandlerReadIndexStatement(MySqlParser.HandlerReadIndexStatementContext ctx) {

    }

    @Override
    public void exitHandlerReadIndexStatement(MySqlParser.HandlerReadIndexStatementContext ctx) {

    }

    @Override
    public void enterHandlerReadStatement(MySqlParser.HandlerReadStatementContext ctx) {

    }

    @Override
    public void exitHandlerReadStatement(MySqlParser.HandlerReadStatementContext ctx) {

    }

    @Override
    public void enterHandlerCloseStatement(MySqlParser.HandlerCloseStatementContext ctx) {

    }

    @Override
    public void exitHandlerCloseStatement(MySqlParser.HandlerCloseStatementContext ctx) {

    }

    @Override
    public void enterSingleUpdateStatement(MySqlParser.SingleUpdateStatementContext ctx) {

    }

    @Override
    public void exitSingleUpdateStatement(MySqlParser.SingleUpdateStatementContext ctx) {

    }

    @Override
    public void enterMultipleUpdateStatement(MySqlParser.MultipleUpdateStatementContext ctx) {

    }

    @Override
    public void exitMultipleUpdateStatement(MySqlParser.MultipleUpdateStatementContext ctx) {

    }

    @Override
    public void enterOrderByClause(MySqlParser.OrderByClauseContext ctx) {

    }

    @Override
    public void exitOrderByClause(MySqlParser.OrderByClauseContext ctx) {

    }

    @Override
    public void enterOrderByExpression(MySqlParser.OrderByExpressionContext ctx) {

    }

    @Override
    public void exitOrderByExpression(MySqlParser.OrderByExpressionContext ctx) {

    }

    @Override
    public void enterTableSources(MySqlParser.TableSourcesContext ctx) {

    }

    @Override
    public void exitTableSources(MySqlParser.TableSourcesContext ctx) {

    }

    @Override
    public void enterTableSourceBase(MySqlParser.TableSourceBaseContext ctx) {

    }

    @Override
    public void exitTableSourceBase(MySqlParser.TableSourceBaseContext ctx) {

    }

    @Override
    public void enterTableSourceNested(MySqlParser.TableSourceNestedContext ctx) {

    }

    @Override
    public void exitTableSourceNested(MySqlParser.TableSourceNestedContext ctx) {

    }

    @Override
    public void enterAtomTableItem(MySqlParser.AtomTableItemContext ctx) {

    }

    @Override
    public void exitAtomTableItem(MySqlParser.AtomTableItemContext ctx) {

    }

    @Override
    public void enterSubqueryTableItem(MySqlParser.SubqueryTableItemContext ctx) {

    }

    @Override
    public void exitSubqueryTableItem(MySqlParser.SubqueryTableItemContext ctx) {

    }

    @Override
    public void enterTableSourcesItem(MySqlParser.TableSourcesItemContext ctx) {

    }

    @Override
    public void exitTableSourcesItem(MySqlParser.TableSourcesItemContext ctx) {

    }

    @Override
    public void enterIndexHint(MySqlParser.IndexHintContext ctx) {

    }

    @Override
    public void exitIndexHint(MySqlParser.IndexHintContext ctx) {

    }

    @Override
    public void enterIndexHintType(MySqlParser.IndexHintTypeContext ctx) {

    }

    @Override
    public void exitIndexHintType(MySqlParser.IndexHintTypeContext ctx) {

    }

    @Override
    public void enterInnerJoin(MySqlParser.InnerJoinContext ctx) {

    }

    @Override
    public void exitInnerJoin(MySqlParser.InnerJoinContext ctx) {

    }

    @Override
    public void enterStraightJoin(MySqlParser.StraightJoinContext ctx) {

    }

    @Override
    public void exitStraightJoin(MySqlParser.StraightJoinContext ctx) {

    }

    @Override
    public void enterOuterJoin(MySqlParser.OuterJoinContext ctx) {

    }

    @Override
    public void exitOuterJoin(MySqlParser.OuterJoinContext ctx) {

    }

    @Override
    public void enterNaturalJoin(MySqlParser.NaturalJoinContext ctx) {

    }

    @Override
    public void exitNaturalJoin(MySqlParser.NaturalJoinContext ctx) {

    }

    @Override
    public void enterQueryExpression(MySqlParser.QueryExpressionContext ctx) {

    }

    @Override
    public void exitQueryExpression(MySqlParser.QueryExpressionContext ctx) {

    }

    @Override
    public void enterQueryExpressionNointo(MySqlParser.QueryExpressionNointoContext ctx) {

    }

    @Override
    public void exitQueryExpressionNointo(MySqlParser.QueryExpressionNointoContext ctx) {

    }

    @Override
    public void enterQuerySpecification(MySqlParser.QuerySpecificationContext ctx) {

    }

    @Override
    public void exitQuerySpecification(MySqlParser.QuerySpecificationContext ctx) {

    }

    @Override
    public void enterQuerySpecificationNointo(MySqlParser.QuerySpecificationNointoContext ctx) {

    }

    @Override
    public void exitQuerySpecificationNointo(MySqlParser.QuerySpecificationNointoContext ctx) {

    }

    @Override
    public void enterUnionParenthesis(MySqlParser.UnionParenthesisContext ctx) {

    }

    @Override
    public void exitUnionParenthesis(MySqlParser.UnionParenthesisContext ctx) {

    }

    @Override
    public void enterUnionStatement(MySqlParser.UnionStatementContext ctx) {

    }

    @Override
    public void exitUnionStatement(MySqlParser.UnionStatementContext ctx) {

    }

    @Override
    public void enterSelectSpec(MySqlParser.SelectSpecContext ctx) {

    }

    @Override
    public void exitSelectSpec(MySqlParser.SelectSpecContext ctx) {

    }

    @Override
    public void enterSelectElements(MySqlParser.SelectElementsContext ctx) {

    }

    @Override
    public void exitSelectElements(MySqlParser.SelectElementsContext ctx) {

    }

    @Override
    public void enterSelectStarElement(MySqlParser.SelectStarElementContext ctx) {

    }

    @Override
    public void exitSelectStarElement(MySqlParser.SelectStarElementContext ctx) {

    }

    @Override
    public void enterSelectColumnElement(MySqlParser.SelectColumnElementContext ctx) {

    }

    @Override
    public void exitSelectColumnElement(MySqlParser.SelectColumnElementContext ctx) {

    }

    @Override
    public void enterSelectFunctionElement(MySqlParser.SelectFunctionElementContext ctx) {

    }

    @Override
    public void exitSelectFunctionElement(MySqlParser.SelectFunctionElementContext ctx) {

    }

    @Override
    public void enterSelectExpressionElement(MySqlParser.SelectExpressionElementContext ctx) {

    }

    @Override
    public void exitSelectExpressionElement(MySqlParser.SelectExpressionElementContext ctx) {

    }

    @Override
    public void enterSelectIntoVariables(MySqlParser.SelectIntoVariablesContext ctx) {

    }

    @Override
    public void exitSelectIntoVariables(MySqlParser.SelectIntoVariablesContext ctx) {

    }

    @Override
    public void enterSelectIntoDumpFile(MySqlParser.SelectIntoDumpFileContext ctx) {

    }

    @Override
    public void exitSelectIntoDumpFile(MySqlParser.SelectIntoDumpFileContext ctx) {

    }

    @Override
    public void enterSelectIntoTextFile(MySqlParser.SelectIntoTextFileContext ctx) {

    }

    @Override
    public void exitSelectIntoTextFile(MySqlParser.SelectIntoTextFileContext ctx) {

    }

    @Override
    public void enterSelectFieldsInto(MySqlParser.SelectFieldsIntoContext ctx) {

    }

    @Override
    public void exitSelectFieldsInto(MySqlParser.SelectFieldsIntoContext ctx) {

    }

    @Override
    public void enterSelectLinesInto(MySqlParser.SelectLinesIntoContext ctx) {

    }

    @Override
    public void exitSelectLinesInto(MySqlParser.SelectLinesIntoContext ctx) {

    }

    @Override
    public void enterFromClause(MySqlParser.FromClauseContext ctx) {

    }

    @Override
    public void exitFromClause(MySqlParser.FromClauseContext ctx) {

    }

    @Override
    public void enterGroupByClause(MySqlParser.GroupByClauseContext ctx) {

    }

    @Override
    public void exitGroupByClause(MySqlParser.GroupByClauseContext ctx) {

    }

    @Override
    public void enterHavingClause(MySqlParser.HavingClauseContext ctx) {

    }

    @Override
    public void exitHavingClause(MySqlParser.HavingClauseContext ctx) {

    }

    @Override
    public void enterGroupByItem(MySqlParser.GroupByItemContext ctx) {

    }

    @Override
    public void exitGroupByItem(MySqlParser.GroupByItemContext ctx) {

    }

    @Override
    public void enterLimitClause(MySqlParser.LimitClauseContext ctx) {

    }

    @Override
    public void exitLimitClause(MySqlParser.LimitClauseContext ctx) {

    }

    @Override
    public void enterLimitClauseAtom(MySqlParser.LimitClauseAtomContext ctx) {

    }

    @Override
    public void exitLimitClauseAtom(MySqlParser.LimitClauseAtomContext ctx) {

    }

    @Override
    public void enterStartTransaction(MySqlParser.StartTransactionContext ctx) {

    }

    @Override
    public void exitStartTransaction(MySqlParser.StartTransactionContext ctx) {

    }

    @Override
    public void enterBeginWork(MySqlParser.BeginWorkContext ctx) {

    }

    @Override
    public void exitBeginWork(MySqlParser.BeginWorkContext ctx) {

    }

    @Override
    public void enterCommitWork(MySqlParser.CommitWorkContext ctx) {

    }

    @Override
    public void exitCommitWork(MySqlParser.CommitWorkContext ctx) {

    }

    @Override
    public void enterRollbackWork(MySqlParser.RollbackWorkContext ctx) {

    }

    @Override
    public void exitRollbackWork(MySqlParser.RollbackWorkContext ctx) {

    }

    @Override
    public void enterSavepointStatement(MySqlParser.SavepointStatementContext ctx) {

    }

    @Override
    public void exitSavepointStatement(MySqlParser.SavepointStatementContext ctx) {

    }

    @Override
    public void enterRollbackStatement(MySqlParser.RollbackStatementContext ctx) {

    }

    @Override
    public void exitRollbackStatement(MySqlParser.RollbackStatementContext ctx) {

    }

    @Override
    public void enterReleaseStatement(MySqlParser.ReleaseStatementContext ctx) {

    }

    @Override
    public void exitReleaseStatement(MySqlParser.ReleaseStatementContext ctx) {

    }

    @Override
    public void enterLockTables(MySqlParser.LockTablesContext ctx) {

    }

    @Override
    public void exitLockTables(MySqlParser.LockTablesContext ctx) {

    }

    @Override
    public void enterUnlockTables(MySqlParser.UnlockTablesContext ctx) {

    }

    @Override
    public void exitUnlockTables(MySqlParser.UnlockTablesContext ctx) {

    }

    @Override
    public void enterSetAutocommitStatement(MySqlParser.SetAutocommitStatementContext ctx) {

    }

    @Override
    public void exitSetAutocommitStatement(MySqlParser.SetAutocommitStatementContext ctx) {

    }

    @Override
    public void enterSetTransactionStatement(MySqlParser.SetTransactionStatementContext ctx) {

    }

    @Override
    public void exitSetTransactionStatement(MySqlParser.SetTransactionStatementContext ctx) {

    }

    @Override
    public void enterTransactionMode(MySqlParser.TransactionModeContext ctx) {

    }

    @Override
    public void exitTransactionMode(MySqlParser.TransactionModeContext ctx) {

    }

    @Override
    public void enterLockTableElement(MySqlParser.LockTableElementContext ctx) {

    }

    @Override
    public void exitLockTableElement(MySqlParser.LockTableElementContext ctx) {

    }

    @Override
    public void enterLockAction(MySqlParser.LockActionContext ctx) {

    }

    @Override
    public void exitLockAction(MySqlParser.LockActionContext ctx) {

    }

    @Override
    public void enterTransactionOption(MySqlParser.TransactionOptionContext ctx) {

    }

    @Override
    public void exitTransactionOption(MySqlParser.TransactionOptionContext ctx) {

    }

    @Override
    public void enterTransactionLevel(MySqlParser.TransactionLevelContext ctx) {

    }

    @Override
    public void exitTransactionLevel(MySqlParser.TransactionLevelContext ctx) {

    }

    @Override
    public void enterChangeMaster(MySqlParser.ChangeMasterContext ctx) {

    }

    @Override
    public void exitChangeMaster(MySqlParser.ChangeMasterContext ctx) {

    }

    @Override
    public void enterChangeReplicationFilter(MySqlParser.ChangeReplicationFilterContext ctx) {

    }

    @Override
    public void exitChangeReplicationFilter(MySqlParser.ChangeReplicationFilterContext ctx) {

    }

    @Override
    public void enterPurgeBinaryLogs(MySqlParser.PurgeBinaryLogsContext ctx) {

    }

    @Override
    public void exitPurgeBinaryLogs(MySqlParser.PurgeBinaryLogsContext ctx) {

    }

    @Override
    public void enterResetMaster(MySqlParser.ResetMasterContext ctx) {

    }

    @Override
    public void exitResetMaster(MySqlParser.ResetMasterContext ctx) {

    }

    @Override
    public void enterResetSlave(MySqlParser.ResetSlaveContext ctx) {

    }

    @Override
    public void exitResetSlave(MySqlParser.ResetSlaveContext ctx) {

    }

    @Override
    public void enterStartSlave(MySqlParser.StartSlaveContext ctx) {

    }

    @Override
    public void exitStartSlave(MySqlParser.StartSlaveContext ctx) {

    }

    @Override
    public void enterStopSlave(MySqlParser.StopSlaveContext ctx) {

    }

    @Override
    public void exitStopSlave(MySqlParser.StopSlaveContext ctx) {

    }

    @Override
    public void enterStartGroupReplication(MySqlParser.StartGroupReplicationContext ctx) {

    }

    @Override
    public void exitStartGroupReplication(MySqlParser.StartGroupReplicationContext ctx) {

    }

    @Override
    public void enterStopGroupReplication(MySqlParser.StopGroupReplicationContext ctx) {

    }

    @Override
    public void exitStopGroupReplication(MySqlParser.StopGroupReplicationContext ctx) {

    }

    @Override
    public void enterMasterStringOption(MySqlParser.MasterStringOptionContext ctx) {

    }

    @Override
    public void exitMasterStringOption(MySqlParser.MasterStringOptionContext ctx) {

    }

    @Override
    public void enterMasterDecimalOption(MySqlParser.MasterDecimalOptionContext ctx) {

    }

    @Override
    public void exitMasterDecimalOption(MySqlParser.MasterDecimalOptionContext ctx) {

    }

    @Override
    public void enterMasterBoolOption(MySqlParser.MasterBoolOptionContext ctx) {

    }

    @Override
    public void exitMasterBoolOption(MySqlParser.MasterBoolOptionContext ctx) {

    }

    @Override
    public void enterMasterRealOption(MySqlParser.MasterRealOptionContext ctx) {

    }

    @Override
    public void exitMasterRealOption(MySqlParser.MasterRealOptionContext ctx) {

    }

    @Override
    public void enterMasterUidListOption(MySqlParser.MasterUidListOptionContext ctx) {

    }

    @Override
    public void exitMasterUidListOption(MySqlParser.MasterUidListOptionContext ctx) {

    }

    @Override
    public void enterStringMasterOption(MySqlParser.StringMasterOptionContext ctx) {

    }

    @Override
    public void exitStringMasterOption(MySqlParser.StringMasterOptionContext ctx) {

    }

    @Override
    public void enterDecimalMasterOption(MySqlParser.DecimalMasterOptionContext ctx) {

    }

    @Override
    public void exitDecimalMasterOption(MySqlParser.DecimalMasterOptionContext ctx) {

    }

    @Override
    public void enterBoolMasterOption(MySqlParser.BoolMasterOptionContext ctx) {

    }

    @Override
    public void exitBoolMasterOption(MySqlParser.BoolMasterOptionContext ctx) {

    }

    @Override
    public void enterChannelOption(MySqlParser.ChannelOptionContext ctx) {

    }

    @Override
    public void exitChannelOption(MySqlParser.ChannelOptionContext ctx) {

    }

    @Override
    public void enterDoDbReplication(MySqlParser.DoDbReplicationContext ctx) {

    }

    @Override
    public void exitDoDbReplication(MySqlParser.DoDbReplicationContext ctx) {

    }

    @Override
    public void enterIgnoreDbReplication(MySqlParser.IgnoreDbReplicationContext ctx) {

    }

    @Override
    public void exitIgnoreDbReplication(MySqlParser.IgnoreDbReplicationContext ctx) {

    }

    @Override
    public void enterDoTableReplication(MySqlParser.DoTableReplicationContext ctx) {

    }

    @Override
    public void exitDoTableReplication(MySqlParser.DoTableReplicationContext ctx) {

    }

    @Override
    public void enterIgnoreTableReplication(MySqlParser.IgnoreTableReplicationContext ctx) {

    }

    @Override
    public void exitIgnoreTableReplication(MySqlParser.IgnoreTableReplicationContext ctx) {

    }

    @Override
    public void enterWildDoTableReplication(MySqlParser.WildDoTableReplicationContext ctx) {

    }

    @Override
    public void exitWildDoTableReplication(MySqlParser.WildDoTableReplicationContext ctx) {

    }

    @Override
    public void enterWildIgnoreTableReplication(MySqlParser.WildIgnoreTableReplicationContext ctx) {

    }

    @Override
    public void exitWildIgnoreTableReplication(MySqlParser.WildIgnoreTableReplicationContext ctx) {

    }

    @Override
    public void enterRewriteDbReplication(MySqlParser.RewriteDbReplicationContext ctx) {

    }

    @Override
    public void exitRewriteDbReplication(MySqlParser.RewriteDbReplicationContext ctx) {

    }

    @Override
    public void enterTablePair(MySqlParser.TablePairContext ctx) {

    }

    @Override
    public void exitTablePair(MySqlParser.TablePairContext ctx) {

    }

    @Override
    public void enterThreadType(MySqlParser.ThreadTypeContext ctx) {

    }

    @Override
    public void exitThreadType(MySqlParser.ThreadTypeContext ctx) {

    }

    @Override
    public void enterGtidsUntilOption(MySqlParser.GtidsUntilOptionContext ctx) {

    }

    @Override
    public void exitGtidsUntilOption(MySqlParser.GtidsUntilOptionContext ctx) {

    }

    @Override
    public void enterMasterLogUntilOption(MySqlParser.MasterLogUntilOptionContext ctx) {

    }

    @Override
    public void exitMasterLogUntilOption(MySqlParser.MasterLogUntilOptionContext ctx) {

    }

    @Override
    public void enterRelayLogUntilOption(MySqlParser.RelayLogUntilOptionContext ctx) {

    }

    @Override
    public void exitRelayLogUntilOption(MySqlParser.RelayLogUntilOptionContext ctx) {

    }

    @Override
    public void enterSqlGapsUntilOption(MySqlParser.SqlGapsUntilOptionContext ctx) {

    }

    @Override
    public void exitSqlGapsUntilOption(MySqlParser.SqlGapsUntilOptionContext ctx) {

    }

    @Override
    public void enterUserConnectionOption(MySqlParser.UserConnectionOptionContext ctx) {

    }

    @Override
    public void exitUserConnectionOption(MySqlParser.UserConnectionOptionContext ctx) {

    }

    @Override
    public void enterPasswordConnectionOption(MySqlParser.PasswordConnectionOptionContext ctx) {

    }

    @Override
    public void exitPasswordConnectionOption(MySqlParser.PasswordConnectionOptionContext ctx) {

    }

    @Override
    public void enterDefaultAuthConnectionOption(MySqlParser.DefaultAuthConnectionOptionContext ctx) {

    }

    @Override
    public void exitDefaultAuthConnectionOption(MySqlParser.DefaultAuthConnectionOptionContext ctx) {

    }

    @Override
    public void enterPluginDirConnectionOption(MySqlParser.PluginDirConnectionOptionContext ctx) {

    }

    @Override
    public void exitPluginDirConnectionOption(MySqlParser.PluginDirConnectionOptionContext ctx) {

    }

    @Override
    public void enterGtuidSet(MySqlParser.GtuidSetContext ctx) {

    }

    @Override
    public void exitGtuidSet(MySqlParser.GtuidSetContext ctx) {

    }

    @Override
    public void enterXaStartTransaction(MySqlParser.XaStartTransactionContext ctx) {

    }

    @Override
    public void exitXaStartTransaction(MySqlParser.XaStartTransactionContext ctx) {

    }

    @Override
    public void enterXaEndTransaction(MySqlParser.XaEndTransactionContext ctx) {

    }

    @Override
    public void exitXaEndTransaction(MySqlParser.XaEndTransactionContext ctx) {

    }

    @Override
    public void enterXaPrepareStatement(MySqlParser.XaPrepareStatementContext ctx) {

    }

    @Override
    public void exitXaPrepareStatement(MySqlParser.XaPrepareStatementContext ctx) {

    }

    @Override
    public void enterXaCommitWork(MySqlParser.XaCommitWorkContext ctx) {

    }

    @Override
    public void exitXaCommitWork(MySqlParser.XaCommitWorkContext ctx) {

    }

    @Override
    public void enterXaRollbackWork(MySqlParser.XaRollbackWorkContext ctx) {

    }

    @Override
    public void exitXaRollbackWork(MySqlParser.XaRollbackWorkContext ctx) {

    }

    @Override
    public void enterXaRecoverWork(MySqlParser.XaRecoverWorkContext ctx) {

    }

    @Override
    public void exitXaRecoverWork(MySqlParser.XaRecoverWorkContext ctx) {

    }

    @Override
    public void enterPrepareStatement(MySqlParser.PrepareStatementContext ctx) {

    }

    @Override
    public void exitPrepareStatement(MySqlParser.PrepareStatementContext ctx) {

    }

    @Override
    public void enterExecuteStatement(MySqlParser.ExecuteStatementContext ctx) {

    }

    @Override
    public void exitExecuteStatement(MySqlParser.ExecuteStatementContext ctx) {

    }

    @Override
    public void enterDeallocatePrepare(MySqlParser.DeallocatePrepareContext ctx) {

    }

    @Override
    public void exitDeallocatePrepare(MySqlParser.DeallocatePrepareContext ctx) {

    }

    @Override
    public void enterRoutineBody(MySqlParser.RoutineBodyContext ctx) {

    }

    @Override
    public void exitRoutineBody(MySqlParser.RoutineBodyContext ctx) {

    }

    @Override
    public void enterBlockStatement(MySqlParser.BlockStatementContext ctx) {

    }

    @Override
    public void exitBlockStatement(MySqlParser.BlockStatementContext ctx) {

    }

    @Override
    public void enterCaseStatement(MySqlParser.CaseStatementContext ctx) {

    }

    @Override
    public void exitCaseStatement(MySqlParser.CaseStatementContext ctx) {

    }

    @Override
    public void enterIfStatement(MySqlParser.IfStatementContext ctx) {

    }

    @Override
    public void exitIfStatement(MySqlParser.IfStatementContext ctx) {

    }

    @Override
    public void enterIterateStatement(MySqlParser.IterateStatementContext ctx) {

    }

    @Override
    public void exitIterateStatement(MySqlParser.IterateStatementContext ctx) {

    }

    @Override
    public void enterLeaveStatement(MySqlParser.LeaveStatementContext ctx) {

    }

    @Override
    public void exitLeaveStatement(MySqlParser.LeaveStatementContext ctx) {

    }

    @Override
    public void enterLoopStatement(MySqlParser.LoopStatementContext ctx) {

    }

    @Override
    public void exitLoopStatement(MySqlParser.LoopStatementContext ctx) {

    }

    @Override
    public void enterRepeatStatement(MySqlParser.RepeatStatementContext ctx) {

    }

    @Override
    public void exitRepeatStatement(MySqlParser.RepeatStatementContext ctx) {

    }

    @Override
    public void enterReturnStatement(MySqlParser.ReturnStatementContext ctx) {

    }

    @Override
    public void exitReturnStatement(MySqlParser.ReturnStatementContext ctx) {

    }

    @Override
    public void enterWhileStatement(MySqlParser.WhileStatementContext ctx) {

    }

    @Override
    public void exitWhileStatement(MySqlParser.WhileStatementContext ctx) {

    }

    @Override
    public void enterCloseCursor(MySqlParser.CloseCursorContext ctx) {

    }

    @Override
    public void exitCloseCursor(MySqlParser.CloseCursorContext ctx) {

    }

    @Override
    public void enterFetchCursor(MySqlParser.FetchCursorContext ctx) {

    }

    @Override
    public void exitFetchCursor(MySqlParser.FetchCursorContext ctx) {

    }

    @Override
    public void enterOpenCursor(MySqlParser.OpenCursorContext ctx) {

    }

    @Override
    public void exitOpenCursor(MySqlParser.OpenCursorContext ctx) {

    }

    @Override
    public void enterDeclareVariable(MySqlParser.DeclareVariableContext ctx) {

    }

    @Override
    public void exitDeclareVariable(MySqlParser.DeclareVariableContext ctx) {

    }

    @Override
    public void enterDeclareCondition(MySqlParser.DeclareConditionContext ctx) {

    }

    @Override
    public void exitDeclareCondition(MySqlParser.DeclareConditionContext ctx) {

    }

    @Override
    public void enterDeclareCursor(MySqlParser.DeclareCursorContext ctx) {

    }

    @Override
    public void exitDeclareCursor(MySqlParser.DeclareCursorContext ctx) {

    }

    @Override
    public void enterDeclareHandler(MySqlParser.DeclareHandlerContext ctx) {

    }

    @Override
    public void exitDeclareHandler(MySqlParser.DeclareHandlerContext ctx) {

    }

    @Override
    public void enterHandlerConditionCode(MySqlParser.HandlerConditionCodeContext ctx) {

    }

    @Override
    public void exitHandlerConditionCode(MySqlParser.HandlerConditionCodeContext ctx) {

    }

    @Override
    public void enterHandlerConditionState(MySqlParser.HandlerConditionStateContext ctx) {

    }

    @Override
    public void exitHandlerConditionState(MySqlParser.HandlerConditionStateContext ctx) {

    }

    @Override
    public void enterHandlerConditionName(MySqlParser.HandlerConditionNameContext ctx) {

    }

    @Override
    public void exitHandlerConditionName(MySqlParser.HandlerConditionNameContext ctx) {

    }

    @Override
    public void enterHandlerConditionWarning(MySqlParser.HandlerConditionWarningContext ctx) {

    }

    @Override
    public void exitHandlerConditionWarning(MySqlParser.HandlerConditionWarningContext ctx) {

    }

    @Override
    public void enterHandlerConditionNotfound(MySqlParser.HandlerConditionNotfoundContext ctx) {

    }

    @Override
    public void exitHandlerConditionNotfound(MySqlParser.HandlerConditionNotfoundContext ctx) {

    }

    @Override
    public void enterHandlerConditionException(MySqlParser.HandlerConditionExceptionContext ctx) {

    }

    @Override
    public void exitHandlerConditionException(MySqlParser.HandlerConditionExceptionContext ctx) {

    }

    @Override
    public void enterProcedureSqlStatement(MySqlParser.ProcedureSqlStatementContext ctx) {

    }

    @Override
    public void exitProcedureSqlStatement(MySqlParser.ProcedureSqlStatementContext ctx) {

    }

    @Override
    public void enterCaseAlternative(MySqlParser.CaseAlternativeContext ctx) {

    }

    @Override
    public void exitCaseAlternative(MySqlParser.CaseAlternativeContext ctx) {

    }

    @Override
    public void enterElifAlternative(MySqlParser.ElifAlternativeContext ctx) {

    }

    @Override
    public void exitElifAlternative(MySqlParser.ElifAlternativeContext ctx) {

    }

    @Override
    public void enterAlterUserMysqlV56(MySqlParser.AlterUserMysqlV56Context ctx) {

    }

    @Override
    public void exitAlterUserMysqlV56(MySqlParser.AlterUserMysqlV56Context ctx) {

    }

    @Override
    public void enterAlterUserMysqlV57(MySqlParser.AlterUserMysqlV57Context ctx) {

    }

    @Override
    public void exitAlterUserMysqlV57(MySqlParser.AlterUserMysqlV57Context ctx) {

    }

    @Override
    public void enterCreateUserMysqlV56(MySqlParser.CreateUserMysqlV56Context ctx) {

    }

    @Override
    public void exitCreateUserMysqlV56(MySqlParser.CreateUserMysqlV56Context ctx) {

    }

    @Override
    public void enterCreateUserMysqlV57(MySqlParser.CreateUserMysqlV57Context ctx) {

    }

    @Override
    public void exitCreateUserMysqlV57(MySqlParser.CreateUserMysqlV57Context ctx) {

    }

    @Override
    public void enterDropUser(MySqlParser.DropUserContext ctx) {

    }

    @Override
    public void exitDropUser(MySqlParser.DropUserContext ctx) {

    }

    @Override
    public void enterGrantStatement(MySqlParser.GrantStatementContext ctx) {

    }

    @Override
    public void exitGrantStatement(MySqlParser.GrantStatementContext ctx) {

    }

    @Override
    public void enterGrantProxy(MySqlParser.GrantProxyContext ctx) {

    }

    @Override
    public void exitGrantProxy(MySqlParser.GrantProxyContext ctx) {

    }

    @Override
    public void enterRenameUser(MySqlParser.RenameUserContext ctx) {

    }

    @Override
    public void exitRenameUser(MySqlParser.RenameUserContext ctx) {

    }

    @Override
    public void enterDetailRevoke(MySqlParser.DetailRevokeContext ctx) {

    }

    @Override
    public void exitDetailRevoke(MySqlParser.DetailRevokeContext ctx) {

    }

    @Override
    public void enterShortRevoke(MySqlParser.ShortRevokeContext ctx) {

    }

    @Override
    public void exitShortRevoke(MySqlParser.ShortRevokeContext ctx) {

    }

    @Override
    public void enterRoleRevoke(MySqlParser.RoleRevokeContext ctx) {

    }

    @Override
    public void exitRoleRevoke(MySqlParser.RoleRevokeContext ctx) {

    }

    @Override
    public void enterRevokeProxy(MySqlParser.RevokeProxyContext ctx) {

    }

    @Override
    public void exitRevokeProxy(MySqlParser.RevokeProxyContext ctx) {

    }

    @Override
    public void enterSetPasswordStatement(MySqlParser.SetPasswordStatementContext ctx) {

    }

    @Override
    public void exitSetPasswordStatement(MySqlParser.SetPasswordStatementContext ctx) {

    }

    @Override
    public void enterUserSpecification(MySqlParser.UserSpecificationContext ctx) {

    }

    @Override
    public void exitUserSpecification(MySqlParser.UserSpecificationContext ctx) {

    }

    @Override
    public void enterPasswordAuthOption(MySqlParser.PasswordAuthOptionContext ctx) {

    }

    @Override
    public void exitPasswordAuthOption(MySqlParser.PasswordAuthOptionContext ctx) {

    }

    @Override
    public void enterStringAuthOption(MySqlParser.StringAuthOptionContext ctx) {

    }

    @Override
    public void exitStringAuthOption(MySqlParser.StringAuthOptionContext ctx) {

    }

    @Override
    public void enterHashAuthOption(MySqlParser.HashAuthOptionContext ctx) {

    }

    @Override
    public void exitHashAuthOption(MySqlParser.HashAuthOptionContext ctx) {

    }

    @Override
    public void enterSimpleAuthOption(MySqlParser.SimpleAuthOptionContext ctx) {

    }

    @Override
    public void exitSimpleAuthOption(MySqlParser.SimpleAuthOptionContext ctx) {

    }

    @Override
    public void enterTlsOption(MySqlParser.TlsOptionContext ctx) {

    }

    @Override
    public void exitTlsOption(MySqlParser.TlsOptionContext ctx) {

    }

    @Override
    public void enterUserResourceOption(MySqlParser.UserResourceOptionContext ctx) {

    }

    @Override
    public void exitUserResourceOption(MySqlParser.UserResourceOptionContext ctx) {

    }

    @Override
    public void enterUserPasswordOption(MySqlParser.UserPasswordOptionContext ctx) {

    }

    @Override
    public void exitUserPasswordOption(MySqlParser.UserPasswordOptionContext ctx) {

    }

    @Override
    public void enterUserLockOption(MySqlParser.UserLockOptionContext ctx) {

    }

    @Override
    public void exitUserLockOption(MySqlParser.UserLockOptionContext ctx) {

    }

    @Override
    public void enterPrivelegeClause(MySqlParser.PrivelegeClauseContext ctx) {

    }

    @Override
    public void exitPrivelegeClause(MySqlParser.PrivelegeClauseContext ctx) {

    }

    @Override
    public void enterPrivilege(MySqlParser.PrivilegeContext ctx) {

    }

    @Override
    public void exitPrivilege(MySqlParser.PrivilegeContext ctx) {

    }

    @Override
    public void enterCurrentSchemaPriviLevel(MySqlParser.CurrentSchemaPriviLevelContext ctx) {

    }

    @Override
    public void exitCurrentSchemaPriviLevel(MySqlParser.CurrentSchemaPriviLevelContext ctx) {

    }

    @Override
    public void enterGlobalPrivLevel(MySqlParser.GlobalPrivLevelContext ctx) {

    }

    @Override
    public void exitGlobalPrivLevel(MySqlParser.GlobalPrivLevelContext ctx) {

    }

    @Override
    public void enterDefiniteSchemaPrivLevel(MySqlParser.DefiniteSchemaPrivLevelContext ctx) {

    }

    @Override
    public void exitDefiniteSchemaPrivLevel(MySqlParser.DefiniteSchemaPrivLevelContext ctx) {

    }

    @Override
    public void enterDefiniteFullTablePrivLevel(MySqlParser.DefiniteFullTablePrivLevelContext ctx) {

    }

    @Override
    public void exitDefiniteFullTablePrivLevel(MySqlParser.DefiniteFullTablePrivLevelContext ctx) {

    }

    @Override
    public void enterDefiniteFullTablePrivLevel2(MySqlParser.DefiniteFullTablePrivLevel2Context ctx) {

    }

    @Override
    public void exitDefiniteFullTablePrivLevel2(MySqlParser.DefiniteFullTablePrivLevel2Context ctx) {

    }

    @Override
    public void enterDefiniteTablePrivLevel(MySqlParser.DefiniteTablePrivLevelContext ctx) {

    }

    @Override
    public void exitDefiniteTablePrivLevel(MySqlParser.DefiniteTablePrivLevelContext ctx) {

    }

    @Override
    public void enterRenameUserClause(MySqlParser.RenameUserClauseContext ctx) {

    }

    @Override
    public void exitRenameUserClause(MySqlParser.RenameUserClauseContext ctx) {

    }

    @Override
    public void enterAnalyzeTable(MySqlParser.AnalyzeTableContext ctx) {

    }

    @Override
    public void exitAnalyzeTable(MySqlParser.AnalyzeTableContext ctx) {

    }

    @Override
    public void enterCheckTable(MySqlParser.CheckTableContext ctx) {

    }

    @Override
    public void exitCheckTable(MySqlParser.CheckTableContext ctx) {

    }

    @Override
    public void enterChecksumTable(MySqlParser.ChecksumTableContext ctx) {

    }

    @Override
    public void exitChecksumTable(MySqlParser.ChecksumTableContext ctx) {

    }

    @Override
    public void enterOptimizeTable(MySqlParser.OptimizeTableContext ctx) {

    }

    @Override
    public void exitOptimizeTable(MySqlParser.OptimizeTableContext ctx) {

    }

    @Override
    public void enterRepairTable(MySqlParser.RepairTableContext ctx) {

    }

    @Override
    public void exitRepairTable(MySqlParser.RepairTableContext ctx) {

    }

    @Override
    public void enterCheckTableOption(MySqlParser.CheckTableOptionContext ctx) {

    }

    @Override
    public void exitCheckTableOption(MySqlParser.CheckTableOptionContext ctx) {

    }

    @Override
    public void enterCreateUdfunction(MySqlParser.CreateUdfunctionContext ctx) {

    }

    @Override
    public void exitCreateUdfunction(MySqlParser.CreateUdfunctionContext ctx) {

    }

    @Override
    public void enterInstallPlugin(MySqlParser.InstallPluginContext ctx) {

    }

    @Override
    public void exitInstallPlugin(MySqlParser.InstallPluginContext ctx) {

    }

    @Override
    public void enterUninstallPlugin(MySqlParser.UninstallPluginContext ctx) {

    }

    @Override
    public void exitUninstallPlugin(MySqlParser.UninstallPluginContext ctx) {

    }

    @Override
    public void enterSetVariable(MySqlParser.SetVariableContext ctx) {

    }

    @Override
    public void exitSetVariable(MySqlParser.SetVariableContext ctx) {

    }

    @Override
    public void enterSetCharset(MySqlParser.SetCharsetContext ctx) {

    }

    @Override
    public void exitSetCharset(MySqlParser.SetCharsetContext ctx) {

    }

    @Override
    public void enterSetNames(MySqlParser.SetNamesContext ctx) {

    }

    @Override
    public void exitSetNames(MySqlParser.SetNamesContext ctx) {

    }

    @Override
    public void enterSetPassword(MySqlParser.SetPasswordContext ctx) {

    }

    @Override
    public void exitSetPassword(MySqlParser.SetPasswordContext ctx) {

    }

    @Override
    public void enterSetTransaction(MySqlParser.SetTransactionContext ctx) {

    }

    @Override
    public void exitSetTransaction(MySqlParser.SetTransactionContext ctx) {

    }

    @Override
    public void enterSetAutocommit(MySqlParser.SetAutocommitContext ctx) {

    }

    @Override
    public void exitSetAutocommit(MySqlParser.SetAutocommitContext ctx) {

    }

    @Override
    public void enterSetNewValueInsideTrigger(MySqlParser.SetNewValueInsideTriggerContext ctx) {

    }

    @Override
    public void exitSetNewValueInsideTrigger(MySqlParser.SetNewValueInsideTriggerContext ctx) {

    }

    @Override
    public void enterShowMasterLogs(MySqlParser.ShowMasterLogsContext ctx) {

    }

    @Override
    public void exitShowMasterLogs(MySqlParser.ShowMasterLogsContext ctx) {

    }

    @Override
    public void enterShowLogEvents(MySqlParser.ShowLogEventsContext ctx) {

    }

    @Override
    public void exitShowLogEvents(MySqlParser.ShowLogEventsContext ctx) {

    }

    @Override
    public void enterShowObjectFilter(MySqlParser.ShowObjectFilterContext ctx) {

    }

    @Override
    public void exitShowObjectFilter(MySqlParser.ShowObjectFilterContext ctx) {

    }

    @Override
    public void enterShowColumns(MySqlParser.ShowColumnsContext ctx) {

    }

    @Override
    public void exitShowColumns(MySqlParser.ShowColumnsContext ctx) {

    }

    @Override
    public void enterShowCreateDb(MySqlParser.ShowCreateDbContext ctx) {

    }

    @Override
    public void exitShowCreateDb(MySqlParser.ShowCreateDbContext ctx) {

    }

    @Override
    public void enterShowCreateFullIdObject(MySqlParser.ShowCreateFullIdObjectContext ctx) {

    }

    @Override
    public void exitShowCreateFullIdObject(MySqlParser.ShowCreateFullIdObjectContext ctx) {

    }

    @Override
    public void enterShowCreateUser(MySqlParser.ShowCreateUserContext ctx) {

    }

    @Override
    public void exitShowCreateUser(MySqlParser.ShowCreateUserContext ctx) {

    }

    @Override
    public void enterShowEngine(MySqlParser.ShowEngineContext ctx) {

    }

    @Override
    public void exitShowEngine(MySqlParser.ShowEngineContext ctx) {

    }

    @Override
    public void enterShowGlobalInfo(MySqlParser.ShowGlobalInfoContext ctx) {

    }

    @Override
    public void exitShowGlobalInfo(MySqlParser.ShowGlobalInfoContext ctx) {

    }

    @Override
    public void enterShowErrors(MySqlParser.ShowErrorsContext ctx) {

    }

    @Override
    public void exitShowErrors(MySqlParser.ShowErrorsContext ctx) {

    }

    @Override
    public void enterShowCountErrors(MySqlParser.ShowCountErrorsContext ctx) {

    }

    @Override
    public void exitShowCountErrors(MySqlParser.ShowCountErrorsContext ctx) {

    }

    @Override
    public void enterShowSchemaFilter(MySqlParser.ShowSchemaFilterContext ctx) {

    }

    @Override
    public void exitShowSchemaFilter(MySqlParser.ShowSchemaFilterContext ctx) {

    }

    @Override
    public void enterShowRoutine(MySqlParser.ShowRoutineContext ctx) {

    }

    @Override
    public void exitShowRoutine(MySqlParser.ShowRoutineContext ctx) {

    }

    @Override
    public void enterShowGrants(MySqlParser.ShowGrantsContext ctx) {

    }

    @Override
    public void exitShowGrants(MySqlParser.ShowGrantsContext ctx) {

    }

    @Override
    public void enterShowIndexes(MySqlParser.ShowIndexesContext ctx) {

    }

    @Override
    public void exitShowIndexes(MySqlParser.ShowIndexesContext ctx) {

    }

    @Override
    public void enterShowOpenTables(MySqlParser.ShowOpenTablesContext ctx) {

    }

    @Override
    public void exitShowOpenTables(MySqlParser.ShowOpenTablesContext ctx) {

    }

    @Override
    public void enterShowProfile(MySqlParser.ShowProfileContext ctx) {

    }

    @Override
    public void exitShowProfile(MySqlParser.ShowProfileContext ctx) {

    }

    @Override
    public void enterShowSlaveStatus(MySqlParser.ShowSlaveStatusContext ctx) {

    }

    @Override
    public void exitShowSlaveStatus(MySqlParser.ShowSlaveStatusContext ctx) {

    }

    @Override
    public void enterVariableClause(MySqlParser.VariableClauseContext ctx) {

    }

    @Override
    public void exitVariableClause(MySqlParser.VariableClauseContext ctx) {

    }

    @Override
    public void enterShowCommonEntity(MySqlParser.ShowCommonEntityContext ctx) {

    }

    @Override
    public void exitShowCommonEntity(MySqlParser.ShowCommonEntityContext ctx) {

    }

    @Override
    public void enterShowFilter(MySqlParser.ShowFilterContext ctx) {

    }

    @Override
    public void exitShowFilter(MySqlParser.ShowFilterContext ctx) {

    }

    @Override
    public void enterShowGlobalInfoClause(MySqlParser.ShowGlobalInfoClauseContext ctx) {

    }

    @Override
    public void exitShowGlobalInfoClause(MySqlParser.ShowGlobalInfoClauseContext ctx) {

    }

    @Override
    public void enterShowSchemaEntity(MySqlParser.ShowSchemaEntityContext ctx) {

    }

    @Override
    public void exitShowSchemaEntity(MySqlParser.ShowSchemaEntityContext ctx) {

    }

    @Override
    public void enterShowProfileType(MySqlParser.ShowProfileTypeContext ctx) {

    }

    @Override
    public void exitShowProfileType(MySqlParser.ShowProfileTypeContext ctx) {

    }

    @Override
    public void enterBinlogStatement(MySqlParser.BinlogStatementContext ctx) {

    }

    @Override
    public void exitBinlogStatement(MySqlParser.BinlogStatementContext ctx) {

    }

    @Override
    public void enterCacheIndexStatement(MySqlParser.CacheIndexStatementContext ctx) {

    }

    @Override
    public void exitCacheIndexStatement(MySqlParser.CacheIndexStatementContext ctx) {

    }

    @Override
    public void enterFlushStatement(MySqlParser.FlushStatementContext ctx) {

    }

    @Override
    public void exitFlushStatement(MySqlParser.FlushStatementContext ctx) {

    }

    @Override
    public void enterKillStatement(MySqlParser.KillStatementContext ctx) {

    }

    @Override
    public void exitKillStatement(MySqlParser.KillStatementContext ctx) {

    }

    @Override
    public void enterLoadIndexIntoCache(MySqlParser.LoadIndexIntoCacheContext ctx) {

    }

    @Override
    public void exitLoadIndexIntoCache(MySqlParser.LoadIndexIntoCacheContext ctx) {

    }

    @Override
    public void enterResetStatement(MySqlParser.ResetStatementContext ctx) {

    }

    @Override
    public void exitResetStatement(MySqlParser.ResetStatementContext ctx) {

    }

    @Override
    public void enterShutdownStatement(MySqlParser.ShutdownStatementContext ctx) {

    }

    @Override
    public void exitShutdownStatement(MySqlParser.ShutdownStatementContext ctx) {

    }

    @Override
    public void enterTableIndexes(MySqlParser.TableIndexesContext ctx) {

    }

    @Override
    public void exitTableIndexes(MySqlParser.TableIndexesContext ctx) {

    }

    @Override
    public void enterSimpleFlushOption(MySqlParser.SimpleFlushOptionContext ctx) {

    }

    @Override
    public void exitSimpleFlushOption(MySqlParser.SimpleFlushOptionContext ctx) {

    }

    @Override
    public void enterChannelFlushOption(MySqlParser.ChannelFlushOptionContext ctx) {

    }

    @Override
    public void exitChannelFlushOption(MySqlParser.ChannelFlushOptionContext ctx) {

    }

    @Override
    public void enterTableFlushOption(MySqlParser.TableFlushOptionContext ctx) {

    }

    @Override
    public void exitTableFlushOption(MySqlParser.TableFlushOptionContext ctx) {

    }

    @Override
    public void enterFlushTableOption(MySqlParser.FlushTableOptionContext ctx) {

    }

    @Override
    public void exitFlushTableOption(MySqlParser.FlushTableOptionContext ctx) {

    }

    @Override
    public void enterLoadedTableIndexes(MySqlParser.LoadedTableIndexesContext ctx) {

    }

    @Override
    public void exitLoadedTableIndexes(MySqlParser.LoadedTableIndexesContext ctx) {

    }

    @Override
    public void enterSimpleDescribeStatement(MySqlParser.SimpleDescribeStatementContext ctx) {

    }

    @Override
    public void exitSimpleDescribeStatement(MySqlParser.SimpleDescribeStatementContext ctx) {

    }

    @Override
    public void enterFullDescribeStatement(MySqlParser.FullDescribeStatementContext ctx) {

    }

    @Override
    public void exitFullDescribeStatement(MySqlParser.FullDescribeStatementContext ctx) {

    }

    @Override
    public void enterHelpStatement(MySqlParser.HelpStatementContext ctx) {

    }

    @Override
    public void exitHelpStatement(MySqlParser.HelpStatementContext ctx) {

    }

    @Override
    public void enterUseStatement(MySqlParser.UseStatementContext ctx) {

    }

    @Override
    public void exitUseStatement(MySqlParser.UseStatementContext ctx) {

    }

    @Override
    public void enterSignalStatement(MySqlParser.SignalStatementContext ctx) {

    }

    @Override
    public void exitSignalStatement(MySqlParser.SignalStatementContext ctx) {

    }

    @Override
    public void enterResignalStatement(MySqlParser.ResignalStatementContext ctx) {

    }

    @Override
    public void exitResignalStatement(MySqlParser.ResignalStatementContext ctx) {

    }

    @Override
    public void enterSignalConditionInformation(MySqlParser.SignalConditionInformationContext ctx) {

    }

    @Override
    public void exitSignalConditionInformation(MySqlParser.SignalConditionInformationContext ctx) {

    }

    @Override
    public void enterDiagnosticsStatement(MySqlParser.DiagnosticsStatementContext ctx) {

    }

    @Override
    public void exitDiagnosticsStatement(MySqlParser.DiagnosticsStatementContext ctx) {

    }

    @Override
    public void enterDiagnosticsConditionInformationName(MySqlParser.DiagnosticsConditionInformationNameContext ctx) {

    }

    @Override
    public void exitDiagnosticsConditionInformationName(MySqlParser.DiagnosticsConditionInformationNameContext ctx) {

    }

    @Override
    public void enterDescribeStatements(MySqlParser.DescribeStatementsContext ctx) {

    }

    @Override
    public void exitDescribeStatements(MySqlParser.DescribeStatementsContext ctx) {

    }

    @Override
    public void enterDescribeConnection(MySqlParser.DescribeConnectionContext ctx) {

    }

    @Override
    public void exitDescribeConnection(MySqlParser.DescribeConnectionContext ctx) {

    }

    @Override
    public void enterFullId(MySqlParser.FullIdContext ctx) {
        //System.out.println("enterFullId: " + ctx.children);
        walker.walk(new Documentador(), ctx.getChild(0));
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitFullId(MySqlParser.FullIdContext ctx) {

    }

    @Override
    public void enterTableName(MySqlParser.TableNameContext ctx) {

    }

    @Override
    public void exitTableName(MySqlParser.TableNameContext ctx) {

    }

    @Override
    public void enterFullColumnName(MySqlParser.FullColumnNameContext ctx) {

    }

    @Override
    public void exitFullColumnName(MySqlParser.FullColumnNameContext ctx) {

    }

    @Override
    public void enterIndexColumnName(MySqlParser.IndexColumnNameContext ctx) {

    }

    @Override
    public void exitIndexColumnName(MySqlParser.IndexColumnNameContext ctx) {

    }

    @Override
    public void enterUserName(MySqlParser.UserNameContext ctx) {

    }

    @Override
    public void exitUserName(MySqlParser.UserNameContext ctx) {

    }

    @Override
    public void enterMysqlVariable(MySqlParser.MysqlVariableContext ctx) {

    }

    @Override
    public void exitMysqlVariable(MySqlParser.MysqlVariableContext ctx) {

    }

    @Override
    public void enterCharsetName(MySqlParser.CharsetNameContext ctx) {

    }

    @Override
    public void exitCharsetName(MySqlParser.CharsetNameContext ctx) {

    }

    @Override
    public void enterCollationName(MySqlParser.CollationNameContext ctx) {

    }

    @Override
    public void exitCollationName(MySqlParser.CollationNameContext ctx) {

    }

    @Override
    public void enterEngineName(MySqlParser.EngineNameContext ctx) {

    }

    @Override
    public void exitEngineName(MySqlParser.EngineNameContext ctx) {

    }

    @Override
    public void enterUuidSet(MySqlParser.UuidSetContext ctx) {

    }

    @Override
    public void exitUuidSet(MySqlParser.UuidSetContext ctx) {

    }

    @Override
    public void enterXid(MySqlParser.XidContext ctx) {

    }

    @Override
    public void exitXid(MySqlParser.XidContext ctx) {

    }

    @Override
    public void enterXuidStringId(MySqlParser.XuidStringIdContext ctx) {

    }

    @Override
    public void exitXuidStringId(MySqlParser.XuidStringIdContext ctx) {

    }

    @Override
    public void enterAuthPlugin(MySqlParser.AuthPluginContext ctx) {

    }

    @Override
    public void exitAuthPlugin(MySqlParser.AuthPluginContext ctx) {

    }

    @Override
    public void enterUid(MySqlParser.UidContext ctx) {
        //System.out.println("enterUid: " + ctx.children.toString());
        walker.walk(new Documentador(), ctx.getChild(0));
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitUid(MySqlParser.UidContext ctx) {

    }

    @Override
    public void enterSimpleId(MySqlParser.SimpleIdContext ctx) {
        System.out.print(ctx.getChild(0));
        walker.walk(new Documentador(), ctx.getChild(0));
        int childs = ctx.getChildCount();
        for(int i =0; i < childs; i++){
            ctx.removeLastChild();
        }
    }

    @Override
    public void exitSimpleId(MySqlParser.SimpleIdContext ctx) {

    }

    @Override
    public void enterDottedId(MySqlParser.DottedIdContext ctx) {

    }

    @Override
    public void exitDottedId(MySqlParser.DottedIdContext ctx) {

    }

    @Override
    public void enterDecimalLiteral(MySqlParser.DecimalLiteralContext ctx) {

    }

    @Override
    public void exitDecimalLiteral(MySqlParser.DecimalLiteralContext ctx) {

    }

    @Override
    public void enterFileSizeLiteral(MySqlParser.FileSizeLiteralContext ctx) {

    }

    @Override
    public void exitFileSizeLiteral(MySqlParser.FileSizeLiteralContext ctx) {

    }

    @Override
    public void enterStringLiteral(MySqlParser.StringLiteralContext ctx) {

    }

    @Override
    public void exitStringLiteral(MySqlParser.StringLiteralContext ctx) {

    }

    @Override
    public void enterBooleanLiteral(MySqlParser.BooleanLiteralContext ctx) {

    }

    @Override
    public void exitBooleanLiteral(MySqlParser.BooleanLiteralContext ctx) {

    }

    @Override
    public void enterHexadecimalLiteral(MySqlParser.HexadecimalLiteralContext ctx) {

    }

    @Override
    public void exitHexadecimalLiteral(MySqlParser.HexadecimalLiteralContext ctx) {

    }

    @Override
    public void enterNullNotnull(MySqlParser.NullNotnullContext ctx) {

    }

    @Override
    public void exitNullNotnull(MySqlParser.NullNotnullContext ctx) {

    }

    @Override
    public void enterConstant(MySqlParser.ConstantContext ctx) {

    }

    @Override
    public void exitConstant(MySqlParser.ConstantContext ctx) {

    }

    @Override
    public void enterStringDataType(MySqlParser.StringDataTypeContext ctx) {

    }

    @Override
    public void exitStringDataType(MySqlParser.StringDataTypeContext ctx) {

    }

    @Override
    public void enterNationalStringDataType(MySqlParser.NationalStringDataTypeContext ctx) {

    }

    @Override
    public void exitNationalStringDataType(MySqlParser.NationalStringDataTypeContext ctx) {

    }

    @Override
    public void enterNationalVaryingStringDataType(MySqlParser.NationalVaryingStringDataTypeContext ctx) {

    }

    @Override
    public void exitNationalVaryingStringDataType(MySqlParser.NationalVaryingStringDataTypeContext ctx) {

    }

    @Override
    public void enterDimensionDataType(MySqlParser.DimensionDataTypeContext ctx) {

    }

    @Override
    public void exitDimensionDataType(MySqlParser.DimensionDataTypeContext ctx) {

    }

    @Override
    public void enterSimpleDataType(MySqlParser.SimpleDataTypeContext ctx) {

    }

    @Override
    public void exitSimpleDataType(MySqlParser.SimpleDataTypeContext ctx) {

    }

    @Override
    public void enterCollectionDataType(MySqlParser.CollectionDataTypeContext ctx) {

    }

    @Override
    public void exitCollectionDataType(MySqlParser.CollectionDataTypeContext ctx) {

    }

    @Override
    public void enterSpatialDataType(MySqlParser.SpatialDataTypeContext ctx) {

    }

    @Override
    public void exitSpatialDataType(MySqlParser.SpatialDataTypeContext ctx) {

    }

    @Override
    public void enterLongVarcharDataType(MySqlParser.LongVarcharDataTypeContext ctx) {

    }

    @Override
    public void exitLongVarcharDataType(MySqlParser.LongVarcharDataTypeContext ctx) {

    }

    @Override
    public void enterLongVarbinaryDataType(MySqlParser.LongVarbinaryDataTypeContext ctx) {

    }

    @Override
    public void exitLongVarbinaryDataType(MySqlParser.LongVarbinaryDataTypeContext ctx) {

    }

    @Override
    public void enterCollectionOptions(MySqlParser.CollectionOptionsContext ctx) {

    }

    @Override
    public void exitCollectionOptions(MySqlParser.CollectionOptionsContext ctx) {

    }

    @Override
    public void enterConvertedDataType(MySqlParser.ConvertedDataTypeContext ctx) {

    }

    @Override
    public void exitConvertedDataType(MySqlParser.ConvertedDataTypeContext ctx) {

    }

    @Override
    public void enterLengthOneDimension(MySqlParser.LengthOneDimensionContext ctx) {

    }

    @Override
    public void exitLengthOneDimension(MySqlParser.LengthOneDimensionContext ctx) {

    }

    @Override
    public void enterLengthTwoDimension(MySqlParser.LengthTwoDimensionContext ctx) {

    }

    @Override
    public void exitLengthTwoDimension(MySqlParser.LengthTwoDimensionContext ctx) {

    }

    @Override
    public void enterLengthTwoOptionalDimension(MySqlParser.LengthTwoOptionalDimensionContext ctx) {

    }

    @Override
    public void exitLengthTwoOptionalDimension(MySqlParser.LengthTwoOptionalDimensionContext ctx) {

    }

    @Override
    public void enterUidList(MySqlParser.UidListContext ctx) {

    }

    @Override
    public void exitUidList(MySqlParser.UidListContext ctx) {

    }

    @Override
    public void enterTables(MySqlParser.TablesContext ctx) {

    }

    @Override
    public void exitTables(MySqlParser.TablesContext ctx) {

    }

    @Override
    public void enterIndexColumnNames(MySqlParser.IndexColumnNamesContext ctx) {

    }

    @Override
    public void exitIndexColumnNames(MySqlParser.IndexColumnNamesContext ctx) {

    }

    @Override
    public void enterExpressions(MySqlParser.ExpressionsContext ctx) {

    }

    @Override
    public void exitExpressions(MySqlParser.ExpressionsContext ctx) {

    }

    @Override
    public void enterExpressionsWithDefaults(MySqlParser.ExpressionsWithDefaultsContext ctx) {

    }

    @Override
    public void exitExpressionsWithDefaults(MySqlParser.ExpressionsWithDefaultsContext ctx) {

    }

    @Override
    public void enterConstants(MySqlParser.ConstantsContext ctx) {

    }

    @Override
    public void exitConstants(MySqlParser.ConstantsContext ctx) {

    }

    @Override
    public void enterSimpleStrings(MySqlParser.SimpleStringsContext ctx) {

    }

    @Override
    public void exitSimpleStrings(MySqlParser.SimpleStringsContext ctx) {

    }

    @Override
    public void enterUserVariables(MySqlParser.UserVariablesContext ctx) {

    }

    @Override
    public void exitUserVariables(MySqlParser.UserVariablesContext ctx) {

    }

    @Override
    public void enterDefaultValue(MySqlParser.DefaultValueContext ctx) {

    }

    @Override
    public void exitDefaultValue(MySqlParser.DefaultValueContext ctx) {

    }

    @Override
    public void enterCurrentTimestamp(MySqlParser.CurrentTimestampContext ctx) {

    }

    @Override
    public void exitCurrentTimestamp(MySqlParser.CurrentTimestampContext ctx) {

    }

    @Override
    public void enterExpressionOrDefault(MySqlParser.ExpressionOrDefaultContext ctx) {

    }

    @Override
    public void exitExpressionOrDefault(MySqlParser.ExpressionOrDefaultContext ctx) {

    }

    @Override
    public void enterIfExists(MySqlParser.IfExistsContext ctx) {
        System.out.print("(si existe)");
    }

    @Override
    public void exitIfExists(MySqlParser.IfExistsContext ctx) {

    }

    @Override
    public void enterIfNotExists(MySqlParser.IfNotExistsContext ctx) {
        System.out.print("(si no existe)");
    }

    @Override
    public void exitIfNotExists(MySqlParser.IfNotExistsContext ctx) {

    }

    @Override
    public void enterSpecificFunctionCall(MySqlParser.SpecificFunctionCallContext ctx) {

    }

    @Override
    public void exitSpecificFunctionCall(MySqlParser.SpecificFunctionCallContext ctx) {

    }

    @Override
    public void enterAggregateFunctionCall(MySqlParser.AggregateFunctionCallContext ctx) {

    }

    @Override
    public void exitAggregateFunctionCall(MySqlParser.AggregateFunctionCallContext ctx) {

    }

    @Override
    public void enterScalarFunctionCall(MySqlParser.ScalarFunctionCallContext ctx) {

    }

    @Override
    public void exitScalarFunctionCall(MySqlParser.ScalarFunctionCallContext ctx) {

    }

    @Override
    public void enterUdfFunctionCall(MySqlParser.UdfFunctionCallContext ctx) {

    }

    @Override
    public void exitUdfFunctionCall(MySqlParser.UdfFunctionCallContext ctx) {

    }

    @Override
    public void enterPasswordFunctionCall(MySqlParser.PasswordFunctionCallContext ctx) {

    }

    @Override
    public void exitPasswordFunctionCall(MySqlParser.PasswordFunctionCallContext ctx) {

    }

    @Override
    public void enterSimpleFunctionCall(MySqlParser.SimpleFunctionCallContext ctx) {

    }

    @Override
    public void exitSimpleFunctionCall(MySqlParser.SimpleFunctionCallContext ctx) {

    }

    @Override
    public void enterDataTypeFunctionCall(MySqlParser.DataTypeFunctionCallContext ctx) {

    }

    @Override
    public void exitDataTypeFunctionCall(MySqlParser.DataTypeFunctionCallContext ctx) {

    }

    @Override
    public void enterValuesFunctionCall(MySqlParser.ValuesFunctionCallContext ctx) {

    }

    @Override
    public void exitValuesFunctionCall(MySqlParser.ValuesFunctionCallContext ctx) {

    }

    @Override
    public void enterCaseExpressionFunctionCall(MySqlParser.CaseExpressionFunctionCallContext ctx) {

    }

    @Override
    public void exitCaseExpressionFunctionCall(MySqlParser.CaseExpressionFunctionCallContext ctx) {

    }

    @Override
    public void enterCaseFunctionCall(MySqlParser.CaseFunctionCallContext ctx) {

    }

    @Override
    public void exitCaseFunctionCall(MySqlParser.CaseFunctionCallContext ctx) {

    }

    @Override
    public void enterCharFunctionCall(MySqlParser.CharFunctionCallContext ctx) {

    }

    @Override
    public void exitCharFunctionCall(MySqlParser.CharFunctionCallContext ctx) {

    }

    @Override
    public void enterPositionFunctionCall(MySqlParser.PositionFunctionCallContext ctx) {

    }

    @Override
    public void exitPositionFunctionCall(MySqlParser.PositionFunctionCallContext ctx) {

    }

    @Override
    public void enterSubstrFunctionCall(MySqlParser.SubstrFunctionCallContext ctx) {

    }

    @Override
    public void exitSubstrFunctionCall(MySqlParser.SubstrFunctionCallContext ctx) {

    }

    @Override
    public void enterTrimFunctionCall(MySqlParser.TrimFunctionCallContext ctx) {

    }

    @Override
    public void exitTrimFunctionCall(MySqlParser.TrimFunctionCallContext ctx) {

    }

    @Override
    public void enterWeightFunctionCall(MySqlParser.WeightFunctionCallContext ctx) {

    }

    @Override
    public void exitWeightFunctionCall(MySqlParser.WeightFunctionCallContext ctx) {

    }

    @Override
    public void enterExtractFunctionCall(MySqlParser.ExtractFunctionCallContext ctx) {

    }

    @Override
    public void exitExtractFunctionCall(MySqlParser.ExtractFunctionCallContext ctx) {

    }

    @Override
    public void enterGetFormatFunctionCall(MySqlParser.GetFormatFunctionCallContext ctx) {

    }

    @Override
    public void exitGetFormatFunctionCall(MySqlParser.GetFormatFunctionCallContext ctx) {

    }

    @Override
    public void enterJsonValueFunctionCall(MySqlParser.JsonValueFunctionCallContext ctx) {

    }

    @Override
    public void exitJsonValueFunctionCall(MySqlParser.JsonValueFunctionCallContext ctx) {

    }

    @Override
    public void enterCaseFuncAlternative(MySqlParser.CaseFuncAlternativeContext ctx) {

    }

    @Override
    public void exitCaseFuncAlternative(MySqlParser.CaseFuncAlternativeContext ctx) {

    }

    @Override
    public void enterLevelWeightList(MySqlParser.LevelWeightListContext ctx) {

    }

    @Override
    public void exitLevelWeightList(MySqlParser.LevelWeightListContext ctx) {

    }

    @Override
    public void enterLevelWeightRange(MySqlParser.LevelWeightRangeContext ctx) {

    }

    @Override
    public void exitLevelWeightRange(MySqlParser.LevelWeightRangeContext ctx) {

    }

    @Override
    public void enterLevelInWeightListElement(MySqlParser.LevelInWeightListElementContext ctx) {

    }

    @Override
    public void exitLevelInWeightListElement(MySqlParser.LevelInWeightListElementContext ctx) {

    }

    @Override
    public void enterAggregateWindowedFunction(MySqlParser.AggregateWindowedFunctionContext ctx) {

    }

    @Override
    public void exitAggregateWindowedFunction(MySqlParser.AggregateWindowedFunctionContext ctx) {

    }

    @Override
    public void enterScalarFunctionName(MySqlParser.ScalarFunctionNameContext ctx) {

    }

    @Override
    public void exitScalarFunctionName(MySqlParser.ScalarFunctionNameContext ctx) {

    }

    @Override
    public void enterPasswordFunctionClause(MySqlParser.PasswordFunctionClauseContext ctx) {

    }

    @Override
    public void exitPasswordFunctionClause(MySqlParser.PasswordFunctionClauseContext ctx) {

    }

    @Override
    public void enterFunctionArgs(MySqlParser.FunctionArgsContext ctx) {

    }

    @Override
    public void exitFunctionArgs(MySqlParser.FunctionArgsContext ctx) {

    }

    @Override
    public void enterFunctionArg(MySqlParser.FunctionArgContext ctx) {

    }

    @Override
    public void exitFunctionArg(MySqlParser.FunctionArgContext ctx) {

    }

    @Override
    public void enterIsExpression(MySqlParser.IsExpressionContext ctx) {

    }

    @Override
    public void exitIsExpression(MySqlParser.IsExpressionContext ctx) {

    }

    @Override
    public void enterNotExpression(MySqlParser.NotExpressionContext ctx) {

    }

    @Override
    public void exitNotExpression(MySqlParser.NotExpressionContext ctx) {

    }

    @Override
    public void enterLogicalExpression(MySqlParser.LogicalExpressionContext ctx) {

    }

    @Override
    public void exitLogicalExpression(MySqlParser.LogicalExpressionContext ctx) {

    }

    @Override
    public void enterPredicateExpression(MySqlParser.PredicateExpressionContext ctx) {

    }

    @Override
    public void exitPredicateExpression(MySqlParser.PredicateExpressionContext ctx) {

    }

    @Override
    public void enterSoundsLikePredicate(MySqlParser.SoundsLikePredicateContext ctx) {

    }

    @Override
    public void exitSoundsLikePredicate(MySqlParser.SoundsLikePredicateContext ctx) {

    }

    @Override
    public void enterExpressionAtomPredicate(MySqlParser.ExpressionAtomPredicateContext ctx) {

    }

    @Override
    public void exitExpressionAtomPredicate(MySqlParser.ExpressionAtomPredicateContext ctx) {

    }

    @Override
    public void enterSubqueryComparisonPredicate(MySqlParser.SubqueryComparisonPredicateContext ctx) {

    }

    @Override
    public void exitSubqueryComparisonPredicate(MySqlParser.SubqueryComparisonPredicateContext ctx) {

    }

    @Override
    public void enterJsonMemberOfPredicate(MySqlParser.JsonMemberOfPredicateContext ctx) {

    }

    @Override
    public void exitJsonMemberOfPredicate(MySqlParser.JsonMemberOfPredicateContext ctx) {

    }

    @Override
    public void enterBinaryComparisonPredicate(MySqlParser.BinaryComparisonPredicateContext ctx) {

    }

    @Override
    public void exitBinaryComparisonPredicate(MySqlParser.BinaryComparisonPredicateContext ctx) {

    }

    @Override
    public void enterInPredicate(MySqlParser.InPredicateContext ctx) {

    }

    @Override
    public void exitInPredicate(MySqlParser.InPredicateContext ctx) {

    }

    @Override
    public void enterBetweenPredicate(MySqlParser.BetweenPredicateContext ctx) {

    }

    @Override
    public void exitBetweenPredicate(MySqlParser.BetweenPredicateContext ctx) {

    }

    @Override
    public void enterIsNullPredicate(MySqlParser.IsNullPredicateContext ctx) {

    }

    @Override
    public void exitIsNullPredicate(MySqlParser.IsNullPredicateContext ctx) {

    }

    @Override
    public void enterLikePredicate(MySqlParser.LikePredicateContext ctx) {

    }

    @Override
    public void exitLikePredicate(MySqlParser.LikePredicateContext ctx) {

    }

    @Override
    public void enterRegexpPredicate(MySqlParser.RegexpPredicateContext ctx) {

    }

    @Override
    public void exitRegexpPredicate(MySqlParser.RegexpPredicateContext ctx) {

    }

    @Override
    public void enterUnaryExpressionAtom(MySqlParser.UnaryExpressionAtomContext ctx) {

    }

    @Override
    public void exitUnaryExpressionAtom(MySqlParser.UnaryExpressionAtomContext ctx) {

    }

    @Override
    public void enterCollateExpressionAtom(MySqlParser.CollateExpressionAtomContext ctx) {

    }

    @Override
    public void exitCollateExpressionAtom(MySqlParser.CollateExpressionAtomContext ctx) {

    }

    @Override
    public void enterMysqlVariableExpressionAtom(MySqlParser.MysqlVariableExpressionAtomContext ctx) {

    }

    @Override
    public void exitMysqlVariableExpressionAtom(MySqlParser.MysqlVariableExpressionAtomContext ctx) {

    }

    @Override
    public void enterNestedExpressionAtom(MySqlParser.NestedExpressionAtomContext ctx) {

    }

    @Override
    public void exitNestedExpressionAtom(MySqlParser.NestedExpressionAtomContext ctx) {

    }

    @Override
    public void enterNestedRowExpressionAtom(MySqlParser.NestedRowExpressionAtomContext ctx) {

    }

    @Override
    public void exitNestedRowExpressionAtom(MySqlParser.NestedRowExpressionAtomContext ctx) {

    }

    @Override
    public void enterMathExpressionAtom(MySqlParser.MathExpressionAtomContext ctx) {

    }

    @Override
    public void exitMathExpressionAtom(MySqlParser.MathExpressionAtomContext ctx) {

    }

    @Override
    public void enterExistsExpressionAtom(MySqlParser.ExistsExpressionAtomContext ctx) {

    }

    @Override
    public void exitExistsExpressionAtom(MySqlParser.ExistsExpressionAtomContext ctx) {

    }

    @Override
    public void enterIntervalExpressionAtom(MySqlParser.IntervalExpressionAtomContext ctx) {

    }

    @Override
    public void exitIntervalExpressionAtom(MySqlParser.IntervalExpressionAtomContext ctx) {

    }

    @Override
    public void enterJsonExpressionAtom(MySqlParser.JsonExpressionAtomContext ctx) {

    }

    @Override
    public void exitJsonExpressionAtom(MySqlParser.JsonExpressionAtomContext ctx) {

    }

    @Override
    public void enterSubqueryExpressionAtom(MySqlParser.SubqueryExpressionAtomContext ctx) {

    }

    @Override
    public void exitSubqueryExpressionAtom(MySqlParser.SubqueryExpressionAtomContext ctx) {

    }

    @Override
    public void enterConstantExpressionAtom(MySqlParser.ConstantExpressionAtomContext ctx) {

    }

    @Override
    public void exitConstantExpressionAtom(MySqlParser.ConstantExpressionAtomContext ctx) {

    }

    @Override
    public void enterFunctionCallExpressionAtom(MySqlParser.FunctionCallExpressionAtomContext ctx) {

    }

    @Override
    public void exitFunctionCallExpressionAtom(MySqlParser.FunctionCallExpressionAtomContext ctx) {

    }

    @Override
    public void enterBinaryExpressionAtom(MySqlParser.BinaryExpressionAtomContext ctx) {

    }

    @Override
    public void exitBinaryExpressionAtom(MySqlParser.BinaryExpressionAtomContext ctx) {

    }

    @Override
    public void enterFullColumnNameExpressionAtom(MySqlParser.FullColumnNameExpressionAtomContext ctx) {

    }

    @Override
    public void exitFullColumnNameExpressionAtom(MySqlParser.FullColumnNameExpressionAtomContext ctx) {

    }

    @Override
    public void enterBitExpressionAtom(MySqlParser.BitExpressionAtomContext ctx) {

    }

    @Override
    public void exitBitExpressionAtom(MySqlParser.BitExpressionAtomContext ctx) {

    }

    @Override
    public void enterUnaryOperator(MySqlParser.UnaryOperatorContext ctx) {

    }

    @Override
    public void exitUnaryOperator(MySqlParser.UnaryOperatorContext ctx) {

    }

    @Override
    public void enterComparisonOperator(MySqlParser.ComparisonOperatorContext ctx) {

    }

    @Override
    public void exitComparisonOperator(MySqlParser.ComparisonOperatorContext ctx) {

    }

    @Override
    public void enterLogicalOperator(MySqlParser.LogicalOperatorContext ctx) {

    }

    @Override
    public void exitLogicalOperator(MySqlParser.LogicalOperatorContext ctx) {

    }

    @Override
    public void enterBitOperator(MySqlParser.BitOperatorContext ctx) {

    }

    @Override
    public void exitBitOperator(MySqlParser.BitOperatorContext ctx) {

    }

    @Override
    public void enterMathOperator(MySqlParser.MathOperatorContext ctx) {

    }

    @Override
    public void exitMathOperator(MySqlParser.MathOperatorContext ctx) {

    }

    @Override
    public void enterJsonOperator(MySqlParser.JsonOperatorContext ctx) {

    }

    @Override
    public void exitJsonOperator(MySqlParser.JsonOperatorContext ctx) {

    }

    @Override
    public void enterCharsetNameBase(MySqlParser.CharsetNameBaseContext ctx) {

    }

    @Override
    public void exitCharsetNameBase(MySqlParser.CharsetNameBaseContext ctx) {

    }

    @Override
    public void enterTransactionLevelBase(MySqlParser.TransactionLevelBaseContext ctx) {

    }

    @Override
    public void exitTransactionLevelBase(MySqlParser.TransactionLevelBaseContext ctx) {

    }

    @Override
    public void enterPrivilegesBase(MySqlParser.PrivilegesBaseContext ctx) {

    }

    @Override
    public void exitPrivilegesBase(MySqlParser.PrivilegesBaseContext ctx) {

    }

    @Override
    public void enterIntervalTypeBase(MySqlParser.IntervalTypeBaseContext ctx) {

    }

    @Override
    public void exitIntervalTypeBase(MySqlParser.IntervalTypeBaseContext ctx) {

    }

    @Override
    public void enterDataTypeBase(MySqlParser.DataTypeBaseContext ctx) {

    }

    @Override
    public void exitDataTypeBase(MySqlParser.DataTypeBaseContext ctx) {

    }

    @Override
    public void enterKeywordsCanBeId(MySqlParser.KeywordsCanBeIdContext ctx) {

    }

    @Override
    public void exitKeywordsCanBeId(MySqlParser.KeywordsCanBeIdContext ctx) {

    }

    @Override
    public void enterFunctionNameBase(MySqlParser.FunctionNameBaseContext ctx) {

    }

    @Override
    public void exitFunctionNameBase(MySqlParser.FunctionNameBaseContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
