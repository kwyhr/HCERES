/* --------------------------------------------------------------------------------
 * Projet HCERES
 * 
 * Gestion de données pour l'HCERES
 * 
 * Ecole Centrale Nantes - laboratoire CRTI
 * Avril 2021
 * L LETERTRE, S LIMOUX, JY MARTIN
 * -------------------------------------------------------------------------------- */
package org.centrale.hceres.items;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "activity")
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a"),
    @NamedQuery(name = "Activity.findByIdActivity", query = "SELECT a FROM Activity a WHERE a.idActivity = :idActivity")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_activity")
    private Integer idActivity;
    @JoinTable(name = "activity_team", joinColumns = {
        @JoinColumn(name = "id_activity", referencedColumnName = "id_activity")}, inverseJoinColumns = {
        @JoinColumn(name = "team_id", referencedColumnName = "team_id")})
    @ManyToMany
    private Collection<Team> teamCollection;
    @JoinTable(name = "activity_researcher", joinColumns = {
        @JoinColumn(name = "id_activity", referencedColumnName = "id_activity")}, inverseJoinColumns = {
        @JoinColumn(name = "researcher_id", referencedColumnName = "researcher_id")})
    @ManyToMany
    private Collection<Researcher> researcherCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private IncomingMobility incomingMobility;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private Education education;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActivity")
    private Collection<MailActivity> mailActivityCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private NationalInternationalCollaboration nationalInternationalCollaboration;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private Publication publication;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private ScientificExpertise scientificExpertise;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private CompanyCreation companyCreation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private LabcomCreation labcomCreation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private SrAward srAward;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private PublicOutreach publicOutreach;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private ReviewingJournalArticles reviewingJournalArticles;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private EvaluationThesis evaluationThesis;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private SeiNetworkUnitCreation seiNetworkUnitCreation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private ToolProduct toolProduct;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private PostDoc postDoc;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private Patent patent;
    @JoinColumn(name = "id_type_activity", referencedColumnName = "id_type_activity")
    @ManyToOne(optional = false)
    private TypeActivity idTypeActivity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private Book book;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private InvitedSeminar invitedSeminar;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private MeetingCongressOrg meetingCongressOrg;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private BookChapter bookChapter;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private Platform platform;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private Network network;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private InstitutionalComitee institutionalComitee;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private OutgoingMobility outgoingMobility;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private EditorialActivity editorialActivity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private SeiIndustrialRDContract seiIndustrialRDContract;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private ProjectEvaluation projectEvaluation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private LaboratoryEvaluation laboratoryEvaluation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private SeiClinicalTrial seiClinicalTrial;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private OralCommunication oralCommunication;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private ResearchContractFundedPublicCharitableInst researchContractFundedPublicCharitableInst;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private SeiLeadConsortiumIndustry seiLeadConsortiumIndustry;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private SeiCifreFellowship seiCifreFellowship;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private LearnedScientificSociety learnedScientificSociety;

    /**
     *
     */
    public Activity() {
    }

    /**
     *
     * @param idActivity
     */
    public Activity(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @return
     */
    public Integer getIdActivity() {
        return idActivity;
    }

    /**
     *
     * @param idActivity
     */
    public void setIdActivity(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @return
     */
    public Collection<Team> getTeamCollection() {
        return teamCollection;
    }

    /**
     *
     * @param teamCollection
     */
    public void setTeamCollection(Collection<Team> teamCollection) {
        this.teamCollection = teamCollection;
    }

    /**
     *
     * @return
     */
    public Collection<Researcher> getResearcherCollection() {
        return researcherCollection;
    }

    /**
     *
     * @param researcherCollection
     */
    public void setResearcherCollection(Collection<Researcher> researcherCollection) {
        this.researcherCollection = researcherCollection;
    }

    /**
     *
     * @return
     */
    public IncomingMobility getIncomingMobility() {
        return incomingMobility;
    }

    /**
     *
     * @param incomingMobility
     */
    public void setIncomingMobility(IncomingMobility incomingMobility) {
        this.incomingMobility = incomingMobility;
    }

    /**
     *
     * @return
     */
    public Education getEducation() {
        return education;
    }

    /**
     *
     * @param education
     */
    public void setEducation(Education education) {
        this.education = education;
    }

    /**
     *
     * @return
     */
    public Collection<MailActivity> getMailActivityCollection() {
        return mailActivityCollection;
    }

    /**
     *
     * @param mailActivityCollection
     */
    public void setMailActivityCollection(Collection<MailActivity> mailActivityCollection) {
        this.mailActivityCollection = mailActivityCollection;
    }

    /**
     *
     * @return
     */
    public NationalInternationalCollaboration getNationalInternationalCollaboration() {
        return nationalInternationalCollaboration;
    }

    /**
     *
     * @param nationalInternationalCollaboration
     */
    public void setNationalInternationalCollaboration(NationalInternationalCollaboration nationalInternationalCollaboration) {
        this.nationalInternationalCollaboration = nationalInternationalCollaboration;
    }

    /**
     *
     * @return
     */
    public Publication getPublication() {
        return publication;
    }

    /**
     *
     * @param publication
     */
    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    /**
     *
     * @return
     */
    public ScientificExpertise getScientificExpertise() {
        return scientificExpertise;
    }

    /**
     *
     * @param scientificExpertise
     */
    public void setScientificExpertise(ScientificExpertise scientificExpertise) {
        this.scientificExpertise = scientificExpertise;
    }

    /**
     *
     * @return
     */
    public CompanyCreation getCompanyCreation() {
        return companyCreation;
    }

    /**
     *
     * @param companyCreation
     */
    public void setCompanyCreation(CompanyCreation companyCreation) {
        this.companyCreation = companyCreation;
    }

    /**
     *
     * @return
     */
    public LabcomCreation getLabcomCreation() {
        return labcomCreation;
    }

    /**
     *
     * @param labcomCreation
     */
    public void setLabcomCreation(LabcomCreation labcomCreation) {
        this.labcomCreation = labcomCreation;
    }

    /**
     *
     * @return
     */
    public SrAward getSrAward() {
        return srAward;
    }

    /**
     *
     * @param srAward
     */
    public void setSrAward(SrAward srAward) {
        this.srAward = srAward;
    }

    /**
     *
     * @return
     */
    public PublicOutreach getPublicOutreach() {
        return publicOutreach;
    }

    /**
     *
     * @param publicOutreach
     */
    public void setPublicOutreach(PublicOutreach publicOutreach) {
        this.publicOutreach = publicOutreach;
    }

    /**
     *
     * @return
     */
    public ReviewingJournalArticles getReviewingJournalArticles() {
        return reviewingJournalArticles;
    }

    /**
     *
     * @param reviewingJournalArticles
     */
    public void setReviewingJournalArticles(ReviewingJournalArticles reviewingJournalArticles) {
        this.reviewingJournalArticles = reviewingJournalArticles;
    }

    /**
     *
     * @return
     */
    public EvaluationThesis getEvaluationThesis() {
        return evaluationThesis;
    }

    /**
     *
     * @param evaluationThesis
     */
    public void setEvaluationThesis(EvaluationThesis evaluationThesis) {
        this.evaluationThesis = evaluationThesis;
    }

    /**
     *
     * @return
     */
    public SeiNetworkUnitCreation getSeiNetworkUnitCreation() {
        return seiNetworkUnitCreation;
    }

    /**
     *
     * @param seiNetworkUnitCreation
     */
    public void setSeiNetworkUnitCreation(SeiNetworkUnitCreation seiNetworkUnitCreation) {
        this.seiNetworkUnitCreation = seiNetworkUnitCreation;
    }

    /**
     *
     * @return
     */
    public ToolProduct getToolProduct() {
        return toolProduct;
    }

    /**
     *
     * @param toolProduct
     */
    public void setToolProduct(ToolProduct toolProduct) {
        this.toolProduct = toolProduct;
    }

    /**
     *
     * @return
     */
    public PostDoc getPostDoc() {
        return postDoc;
    }

    /**
     *
     * @param postDoc
     */
    public void setPostDoc(PostDoc postDoc) {
        this.postDoc = postDoc;
    }

    /**
     *
     * @return
     */
    public Patent getPatent() {
        return patent;
    }

    /**
     *
     * @param patent
     */
    public void setPatent(Patent patent) {
        this.patent = patent;
    }

    /**
     *
     * @return
     */
    public TypeActivity getIdTypeActivity() {
        return idTypeActivity;
    }

    /**
     *
     * @param idTypeActivity
     */
    public void setIdTypeActivity(TypeActivity idTypeActivity) {
        this.idTypeActivity = idTypeActivity;
    }

    /**
     *
     * @return
     */
    public Book getBook() {
        return book;
    }

    /**
     *
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     *
     * @return
     */
    public InvitedSeminar getInvitedSeminar() {
        return invitedSeminar;
    }

    /**
     *
     * @param invitedSeminar
     */
    public void setInvitedSeminar(InvitedSeminar invitedSeminar) {
        this.invitedSeminar = invitedSeminar;
    }

    /**
     *
     * @return
     */
    public MeetingCongressOrg getMeetingCongressOrg() {
        return meetingCongressOrg;
    }

    /**
     *
     * @param meetingCongressOrg
     */
    public void setMeetingCongressOrg(MeetingCongressOrg meetingCongressOrg) {
        this.meetingCongressOrg = meetingCongressOrg;
    }

    /**
     *
     * @return
     */
    public BookChapter getBookChapter() {
        return bookChapter;
    }

    /**
     *
     * @param bookChapter
     */
    public void setBookChapter(BookChapter bookChapter) {
        this.bookChapter = bookChapter;
    }

    /**
     *
     * @return
     */
    public Platform getPlatform() {
        return platform;
    }

    /**
     *
     * @param platform
     */
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    /**
     *
     * @return
     */
    public Network getNetwork() {
        return network;
    }

    /**
     *
     * @param network
     */
    public void setNetwork(Network network) {
        this.network = network;
    }

    /**
     *
     * @return
     */
    public InstitutionalComitee getInstitutionalComitee() {
        return institutionalComitee;
    }

    /**
     *
     * @param institutionalComitee
     */
    public void setInstitutionalComitee(InstitutionalComitee institutionalComitee) {
        this.institutionalComitee = institutionalComitee;
    }

    /**
     *
     * @return
     */
    public OutgoingMobility getOutgoingMobility() {
        return outgoingMobility;
    }

    /**
     *
     * @param outgoingMobility
     */
    public void setOutgoingMobility(OutgoingMobility outgoingMobility) {
        this.outgoingMobility = outgoingMobility;
    }

    /**
     *
     * @return
     */
    public EditorialActivity getEditorialActivity() {
        return editorialActivity;
    }

    /**
     *
     * @param editorialActivity
     */
    public void setEditorialActivity(EditorialActivity editorialActivity) {
        this.editorialActivity = editorialActivity;
    }

    /**
     *
     * @return
     */
    public SeiIndustrialRDContract getSeiIndustrialRDContract() {
        return seiIndustrialRDContract;
    }

    /**
     *
     * @param seiIndustrialRDContract
     */
    public void setSeiIndustrialRDContract(SeiIndustrialRDContract seiIndustrialRDContract) {
        this.seiIndustrialRDContract = seiIndustrialRDContract;
    }

    /**
     *
     * @return
     */
    public ProjectEvaluation getProjectEvaluation() {
        return projectEvaluation;
    }

    /**
     *
     * @param projectEvaluation
     */
    public void setProjectEvaluation(ProjectEvaluation projectEvaluation) {
        this.projectEvaluation = projectEvaluation;
    }

    /**
     *
     * @return
     */
    public LaboratoryEvaluation getLaboratoryEvaluation() {
        return laboratoryEvaluation;
    }

    /**
     *
     * @param laboratoryEvaluation
     */
    public void setLaboratoryEvaluation(LaboratoryEvaluation laboratoryEvaluation) {
        this.laboratoryEvaluation = laboratoryEvaluation;
    }

    /**
     *
     * @return
     */
    public SeiClinicalTrial getSeiClinicalTrial() {
        return seiClinicalTrial;
    }

    /**
     *
     * @param seiClinicalTrial
     */
    public void setSeiClinicalTrial(SeiClinicalTrial seiClinicalTrial) {
        this.seiClinicalTrial = seiClinicalTrial;
    }

    /**
     *
     * @return
     */
    public OralCommunication getOralCommunication() {
        return oralCommunication;
    }

    /**
     *
     * @param oralCommunication
     */
    public void setOralCommunication(OralCommunication oralCommunication) {
        this.oralCommunication = oralCommunication;
    }

    /**
     *
     * @return
     */
    public ResearchContractFundedPublicCharitableInst getResearchContractFundedPublicCharitableInst() {
        return researchContractFundedPublicCharitableInst;
    }

    /**
     *
     * @param researchContractFundedPublicCharitableInst
     */
    public void setResearchContractFundedPublicCharitableInst(ResearchContractFundedPublicCharitableInst researchContractFundedPublicCharitableInst) {
        this.researchContractFundedPublicCharitableInst = researchContractFundedPublicCharitableInst;
    }

    /**
     *
     * @return
     */
    public SeiLeadConsortiumIndustry getSeiLeadConsortiumIndustry() {
        return seiLeadConsortiumIndustry;
    }

    /**
     *
     * @param seiLeadConsortiumIndustry
     */
    public void setSeiLeadConsortiumIndustry(SeiLeadConsortiumIndustry seiLeadConsortiumIndustry) {
        this.seiLeadConsortiumIndustry = seiLeadConsortiumIndustry;
    }

    /**
     *
     * @return
     */
    public SeiCifreFellowship getSeiCifreFellowship() {
        return seiCifreFellowship;
    }

    /**
     *
     * @param seiCifreFellowship
     */
    public void setSeiCifreFellowship(SeiCifreFellowship seiCifreFellowship) {
        this.seiCifreFellowship = seiCifreFellowship;
    }

    /**
     *
     * @return
     */
    public LearnedScientificSociety getLearnedScientificSociety() {
        return learnedScientificSociety;
    }

    /**
     *
     * @param learnedScientificSociety
     */
    public void setLearnedScientificSociety(LearnedScientificSociety learnedScientificSociety) {
        this.learnedScientificSociety = learnedScientificSociety;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivity != null ? idActivity.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.idActivity == null && other.idActivity != null) || (this.idActivity != null && !this.idActivity.equals(other.idActivity))) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "org.centrale.hceres.items.Activity[ idActivity=" + idActivity + " ]";
    }
    
}
