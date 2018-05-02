gem install --no-document checkstyle_filter-git saddler saddler-reporter-github findbugs_translate_checkstyle_format android_lint_translate_checkstyle_format pmd_translate_checkstyle_format

if [ $? -ne 0 ]; then
    echo 'Failed to install gems.'
    exit 1
fi
    REPORTER=Saddler::Reporter::Github::PullRequestReviewComment
fi

cat presentation/build/reports/ktlint/ktlint-release.xml \
    | checkstyle_filter-git diff origin/master \
    | saddler report --require saddler/reporter/github --reporter $REPORTER

cat domain/build/reports/ktlint/ktlint-release.xml \
    | checkstyle_filter-git diff origin/master \
    | saddler report --require saddler/reporter/github --reporter $REPORTER

cat data/build/reports/ktlint/ktlint-release.xml \
    | checkstyle_filter-git diff origin/master \
    | saddler report --require saddler/reporter/github --reporter $REPORTER
