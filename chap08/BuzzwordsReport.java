package chap08;

class BuzzwordsReport extends Report {
  void runReport() {
    super.runReport();
    buzzwordCompliance();
    printReport();
  }

  void buzzwordCompliance() {}
}