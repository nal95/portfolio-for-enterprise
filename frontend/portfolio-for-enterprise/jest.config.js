module.exports = {
  preset: 'jest-preset-angular',
  roots: ['src'],
  testMatch: ['**/*.spec.ts'],
  setupFilesAfterEnv: ['<rootDir>/src/setup-jest.ts'],
  moduleNameMapper: {
    '@app/(.*)': '<rootDir>/src/app/$1',
    '@assets/(.*)': '<rootDir>/src/assets/$1',
    '@env': '<rootDir>/src/environments/environment',
  },
  collectCoverage: false,
  coverageReporters: ['html'],
  coverageDirectory: 'coverage',
};
